package org.vasechek.services;

import org.vasechek.playback.FileMediaPlayer;
import org.vasechek.playback.MediaPlayer;
import org.vasechek.playback.NetworkMediaPlayer;

public class MediaPlaybackService {
    private MediaPlayer mediaPlayer;

    public void playMedia(String source, boolean isNetwork) {
        if (isNetwork) {
            mediaPlayer = new NetworkMediaPlayer();
        } else {
            mediaPlayer = new FileMediaPlayer();
        }
        mediaPlayer.play(source);
    }

    public void stopMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void pauseMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void resumeMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.resume();
        }
    }
}