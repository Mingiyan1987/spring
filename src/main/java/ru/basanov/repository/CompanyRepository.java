package ru.basanov.repository;

import org.springframework.stereotype.Repository;
import ru.basanov.model.Company;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyRepository extends AbstractRepository {

    public Company removeById(String id) {
        final Company company = findOne(id);
        entityManager.remove(company);
        return company;
    }

    public Company findOne(final String id) {
        return entityManager.find(Company.class, id);
    }

    public Company getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return getEntity(entityManager.createNamedQuery(Company.QUERY_GET_BY_ID, Company.class)
                .setParameter("id", id)
                .setMaxResults(1));
    }

    public Company getAdById(final String id) {
        if (id == null || id.isEmpty()) return null;
        final TypedQuery<Company> query = entityManager.createQuery(Company.QUERY_GET_BY_ID, Company.class);
        return getEntity(query.setParameter("id", id).setMaxResults(1));
    }

    public List<Company> findAll() {
        return entityManager.createQuery(Company.QUERY_FIND_ALL, Company.class).getResultList();
    }

    public void removeAll() { entityManager.createNamedQuery(Company.QUERY_REMOVE_ALL, Company.class).executeUpdate();}

    public List<String> getListCompanyId() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        final Root<Company> root = criteriaQuery.from(Company.class);
        criteriaQuery.multiselect(root.get("id"));
        final TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<Company> getListCompany() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        final TypedQuery<Company> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Long getCountCompany() {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        final Root<Company> root = query.from(Company.class);
        query.select(builder.count(root));
        return entityManager.createQuery(query).getSingleResult();
    }
}
