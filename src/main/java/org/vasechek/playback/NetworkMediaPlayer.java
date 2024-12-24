package org.vasechek.playback;

public class NetworkMediaPlayer implements MediaPlayer {
    @Override
    public void play(String source) {
        System.out.println("Воспроизведение из сети: " + source);
    }

    @Override
    public void stop() {
        System.out.println("Остановка потокового воспроизведения");
    }

    @Override
    public void pause() {
        System.out.println("Пауза потокового воспроизведения");
    }

    @Override
    public void resume() {
        System.out.println("Возобновление потокового воспроизведения");
    }
}