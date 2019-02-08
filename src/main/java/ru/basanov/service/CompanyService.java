package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.Company;
import ru.basanov.repository.CompanyRepository;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company findOne(String id) {
        if (id == null || id.isEmpty()) return null;
        return companyRepository.findOne(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void removeById(String id) {
        if (id == null || id.isEmpty()) return;;
        companyRepository.removeById(id);
    }

    public Company getCompanyById(String id) {
        return companyRepository.getAdById(id);
    }

    public List<String> getListCompanyId() {
        return companyRepository.getListCompanyId();
    }

    public List<Company> getListCompany() {
        return companyRepository.getListCompany();
    }

    public Long getCountCompany() {
        return companyRepository.getCountCompany();
    }

    public void removeAll() {
        companyRepository.removeAll();
    }

}
