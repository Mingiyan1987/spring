package ru.basanov.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.basanov.model.Ad;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AdRepository extends AbstractRepository {

    public Ad findOne(final String id) {
        return entityManager.find(Ad.class, id);
    }

    public Ad getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return getEntity(entityManager.createNamedQuery(Ad.QUERY_GET_BY_ID, Ad.class)
                .setParameter("id", id)
                .setMaxResults(1));
    }

    public Ad getAdById(final String id) {
        if (id == null || id.isEmpty()) return null;
        final TypedQuery<Ad> query = entityManager.createNamedQuery(Ad.QUERY_GET_BY_ID, Ad.class);
        return getEntity(query.setParameter("id", id).setMaxResults(1));
    }

    public List<Ad> findAll() {
        return entityManager.createNamedQuery(Ad.QUERY_FIND_ALL, Ad.class).getResultList();
    }

    public Ad removeById(final String id) {
        final Ad ad = findOne(id);
        entityManager.remove(ad);
        return ad;
    }

    public void removeAll() { entityManager.createNamedQuery(Ad.QUERY_REMOVE_ALL, Ad.class).executeUpdate();}

    public List<String> getListAdId() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        final Root<Ad> root = criteriaQuery.from(Ad.class);
        criteriaQuery.multiselect(root.get("id"));
        final TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<Ad> getListAd() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Ad> criteriaQuery = criteriaBuilder.createQuery(Ad.class);
        final TypedQuery<Ad> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Long getCountAd() {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        final Root<Ad> root = query.from(Ad.class);
        query.select(builder.count(root));
        return entityManager.createQuery(query).getSingleResult();
    }
}
