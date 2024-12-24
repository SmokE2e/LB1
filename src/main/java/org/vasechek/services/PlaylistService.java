package org.vasechek.services;

import org.vasechek.entities.MediaFile;
import org.vasechek.entities.Playlist;
import org.vasechek.repositories.MediaFileRepository;
import org.vasechek.repositories.PlaylistRepository;

import java.util.List;

public class PlaylistService {
    private final PlaylistRepository playlistRepository = new PlaylistRepository();
    private final MediaFileRepository mediaFileRepository = new MediaFileRepository();

    public void createPlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlistRepository.save(playlist);
    }

    public void addMediaToPlaylist(String playlistName, String mediaFileName) {
        Playlist playlist = playlistRepository.findAll().stream()
                .filter(p -> playlistName.equalsIgnoreCase(p.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Плейлист не найден"));

        MediaFile mediaFile = mediaFileRepository.findAll().stream()
                .filter(m -> mediaFileName.equalsIgnoreCase(m.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Медиафайл не найден"));

        playlist.getMediaFiles().add(mediaFile);
        playlistRepository.save(playlist);
    }

    public List<MediaFile> getPlaylistFiles(String playlistName) {
        return playlistRepository.findAll().stream()
                .filter(p -> playlistName.equalsIgnoreCase(p.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Плейлист не найден"))
                .getMediaFiles();
    }
}