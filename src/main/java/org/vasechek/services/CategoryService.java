package org.vasechek.services;

import org.vasechek.entities.Category;
import org.vasechek.entities.MediaFile;
import org.vasechek.repositories.CategoryRepository;
import org.vasechek.repositories.MediaFileRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final MediaFileRepository mediaFileRepository = new MediaFileRepository();

    public void createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    public void addMediaToCategory(String categoryName, String mediaFileName) {
        Category category = categoryRepository.findAll().stream()
                .filter(c -> categoryName.equalsIgnoreCase(c.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));

        MediaFile mediaFile = mediaFileRepository.findAll().stream()
                .filter(m -> mediaFileName.equalsIgnoreCase(m.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Медиафайл не найден"));

        category.getMediaFiles().add(mediaFile);
        categoryRepository.save(category);
    }

    public List<MediaFile> getCategoryFiles(String categoryName) {
        return categoryRepository.findAll().stream()
                .filter(c -> categoryName.equalsIgnoreCase(c.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Категория не найдена"))
                .getMediaFiles();
    }
}