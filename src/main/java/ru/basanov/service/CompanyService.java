package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.model.Company;
import ru.basanov.repository.AbstractRepository;
import ru.basanov.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService extends AbstractRepository implements CompanyRepository{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void persist(Company company) {
        companyRepository.persist(company);
    }

    @Override
    public void merge(Company company) {
        companyRepository.merge(company);
    }

    @Override
    public void remove(Company company) {
        companyRepository.remove(company);
    }

    @Override
    public <S extends Company> S save(S s) {
        return null;
    }

    @Override
    public <S extends Company> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Company> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Company> findAll() {
        return null;
    }

    @Override
    public Iterable<Company> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public void deleteAll(Iterable<? extends Company> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
