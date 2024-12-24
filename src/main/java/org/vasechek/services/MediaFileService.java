package org.vasechek.services;

import org.vasechek.entities.MediaFile;
import org.vasechek.repositories.MediaFileRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MediaFileService {
    private final MediaFileRepository repository = new MediaFileRepository();

    public List<MediaFile> searchByName(String name) {
        return repository.findAll().stream()
                .filter(media -> media.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<MediaFile> searchByGenre(String genre) {
        return repository.findAll().stream()
                .filter(media -> genre.equalsIgnoreCase(media.getGenre()))
                .collect(Collectors.toList());
    }

    public List<MediaFile> searchByDuration(int minDuration, int maxDuration) {
        return repository.findAll().stream()
                .filter(media -> media.getDuration() >= minDuration && media.getDuration() <= maxDuration)
                .collect(Collectors.toList());
    }
}