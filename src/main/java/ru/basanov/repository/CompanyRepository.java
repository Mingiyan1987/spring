package ru.basanov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {

    void persist(Company company);

    void merge(Company company);

    void remove(Company company);
}
