package ru.basanov.enterprise.repository;

import ru.basanov.enterprise.model.Ad;
import ru.basanov.enterprise.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public abstract class AbstractRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public <T> T getEntity(TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
