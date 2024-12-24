package org.vasechek.entities;

import jakarta.persistence.*;

@Entity
public class MediaFile {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String genre;
    private int duration;
    private String source;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public MediaFile() {
    }

    public MediaFile(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public MediaFile(String name, String genre, int duration, String source) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "MediaFile{" +
                "id=" + id +
                ", название='" + name + '\'' +
                ", жанр='" + genre + '\'' +
                ", длительность=" + duration +
                ", источник='" + source + '\'' +
                ", категория='" + (category != null ? category.getName() : "Нет категории") + '\'' +
                '}';
    }
}