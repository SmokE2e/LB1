package org.vasechek.repositories;

import jakarta.persistence.TypedQuery;
import org.vasechek.entities.MediaFile;

import java.util.List;

public class MediaFileRepository extends GenericRepository<MediaFile> {

    public MediaFileRepository() {
        super(MediaFile.class);
    }

    public List<MediaFile> findByName(String name) {
        TypedQuery<MediaFile> query = entityManager.createQuery(
                "SELECT m FROM MediaFile m WHERE LOWER(m.name) LIKE LOWER(:name)", MediaFile.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<MediaFile> findByGenre(String genre) {
        TypedQuery<MediaFile> query = entityManager.createQuery(
                "SELECT m FROM MediaFile m WHERE LOWER(m.genre) LIKE LOWER(:genre)", MediaFile.class);
        query.setParameter("genre", "%" + genre + "%");
        return query.getResultList();
    }

    public List<MediaFile> findByDurationLessThanEqual(int maxDuration) {
        TypedQuery<MediaFile> query = entityManager.createQuery(
                "SELECT m FROM MediaFile m WHERE m.duration <= :maxDuration", MediaFile.class);
        query.setParameter("maxDuration", maxDuration);
        return query.getResultList();
    }
}