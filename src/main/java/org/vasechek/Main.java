package org.vasechek;

import org.vasechek.entities.MediaFile;
import org.vasechek.repositories.MediaFileRepository;
import org.vasechek.services.CategoryService;
import org.vasechek.services.MediaFileService;
import org.vasechek.services.MediaPlaybackService;
import org.vasechek.services.PlaylistService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();
        MediaFileService mediaFileService = new MediaFileService();
        MediaPlaybackService mediaPlaybackService = new MediaPlaybackService();
        PlaylistService playlistService = new PlaylistService();

        MediaFileRepository mediaFileRepository = new MediaFileRepository();
        MediaFile song1 = new MediaFile("Песня Один", "Поп", 180);
        MediaFile song2 = new MediaFile("Песня Два", "Рок", 240);
        MediaFile song3 = new MediaFile("Песня Три", "Поп", 210);
        mediaFileRepository.save(song1);
        mediaFileRepository.save(song2);
        mediaFileRepository.save(song3);

        System.out.println("\n=== Тестирование CategoryService ===");
        categoryService.createCategory("Избранное");
        categoryService.addMediaToCategory("Избранное", "Песня Один");
        categoryService.addMediaToCategory("Избранное", "Песня Три");
        List<MediaFile> favorites = categoryService.getCategoryFiles("Избранное");
        System.out.println("Файлы в категории 'Избранное':");
        favorites.forEach(media -> System.out.println("- " + media.getName()));

        System.out.println("\n=== Тестирование MediaFileService ===");
        System.out.println("Поиск по жанру 'Поп':");
        List<MediaFile> popSongs = mediaFileService.searchByGenre("Поп");
        popSongs.forEach(media -> System.out.println("- " + media.getName()));
        System.out.println("Поиск по длительности (200-250 секунд):");
        List<MediaFile> durationFiltered = mediaFileService.searchByDuration(200, 250);
        durationFiltered.forEach(media -> System.out.println("- " + media.getName()));

        System.out.println("\n=== Тестирование PlaylistService ===");
        playlistService.createPlaylist("Тренировка");
        playlistService.addMediaToPlaylist("Тренировка", "Песня Два");
        playlistService.addMediaToPlaylist("Тренировка", "Песня Три");
        List<MediaFile> workoutPlaylist = playlistService.getPlaylistFiles("Тренировка");
        System.out.println("Файлы в плейлисте 'Тренировка':");
        workoutPlaylist.forEach(media -> System.out.println("- " + media.getName()));

        System.out.println("\n=== Тестирование MediaPlaybackService ===");
        System.out.println("Воспроизведение локального файла:");
        mediaPlaybackService.playMedia("file:///path/to/song_one.mp3", false);
        System.out.println("Остановка воспроизведения:");
        mediaPlaybackService.stopMedia();
        System.out.println("Воспроизведение сетевого файла:");
        mediaPlaybackService.playMedia("https://vasechek.org/song_two.mp3", true);
        System.out.println("Пауза воспроизведения:");
        mediaPlaybackService.pauseMedia();
        System.out.println("Возобновление воспроизведения:");
        mediaPlaybackService.resumeMedia();
        System.out.println("Остановка воспроизведения:");
        mediaPlaybackService.stopMedia();
    }
}