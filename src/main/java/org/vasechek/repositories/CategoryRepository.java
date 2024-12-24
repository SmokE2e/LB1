package org.vasechek.repositories;

import jakarta.persistence.TypedQuery;
import org.vasechek.entities.Category;

import java.util.List;

public class CategoryRepository extends GenericRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }

    public List<Category> findByName(String name) {
        TypedQuery<Category> query = entityManager.createQuery(
                "SELECT c FROM Category c WHERE LOWER(c.name) LIKE LOWER(:name)", Category.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}