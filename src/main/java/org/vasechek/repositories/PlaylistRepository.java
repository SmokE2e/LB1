package org.vasechek.repositories;

import jakarta.persistence.TypedQuery;
import org.vasechek.entities.Playlist;

public class PlaylistRepository extends GenericRepository<Playlist> {

    public PlaylistRepository() {
        super(Playlist.class);
    }

    public Playlist findByName(String name) {
        TypedQuery<Playlist> query = entityManager.createQuery(
                "SELECT p FROM Playlist p WHERE p.name = :name", Playlist.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}