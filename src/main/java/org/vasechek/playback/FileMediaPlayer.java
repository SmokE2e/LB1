package org.vasechek.playback;

public class FileMediaPlayer implements MediaPlayer {
    @Override
    public void play(String source) {
        System.out.println("Воспроизведение файла: " + source);
    }

    @Override
    public void stop() {
        System.out.println("Остановка воспроизведения файла");
    }

    @Override
    public void pause() {
        System.out.println("Пауза воспроизведения файла");
    }

    @Override
    public void resume() {
        System.out.println("Возобновление воспроизведения файла");
    }
}