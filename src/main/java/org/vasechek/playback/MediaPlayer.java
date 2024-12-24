package org.vasechek.playback;

public interface MediaPlayer {
    void play(String source);
    void stop();
    void pause();
    void resume();
}