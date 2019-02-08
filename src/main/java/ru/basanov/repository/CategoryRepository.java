package ru.basanov.repository;

import org.springframework.stereotype.Repository;
import ru.basanov.model.Category;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository {

    public Category removeById(String id) {
        final Category category = findOne(id);
        entityManager.remove(category);
        return category;
    }

    public Category findOne(final String id) {
        return entityManager.find(Category.class, id);
    }

    public Category getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return getEntity(entityManager.createNamedQuery(Category.QUERY_GET_BY_ID, Category.class)
                .setParameter("id", id)
                .setMaxResults(1));
    }

    public Category getCategoryById(final String id) {
        if (id == null || id.isEmpty()) return null;
        final TypedQuery<Category> query = entityManager.createQuery(Category.QUERY_GET_BY_ID, Category.class);
        return getEntity(query.setParameter("id", id).setMaxResults(1));
    }

    public List<Category> findAll() {
        return entityManager.createQuery(Category.QUERY_FIND_ALL, Category.class).getResultList();
    }

    public void removeAll() { entityManager.createNamedQuery(Category.QUERY_REMOVE_ALL, Category.class).executeUpdate();}

    public List<String> getListCategoryId() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        final Root<Category> root = criteriaQuery.from(Category.class);
        criteriaQuery.multiselect(root.get("id"));
        final TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<Category> getListCategory() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
        final TypedQuery<Category> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Long getCountCategory() {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        final Root<Category> root = query.from(Category.class);
        query.select(builder.count(root));
        return entityManager.createQuery(query).getSingleResult();
    }
}
