package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.AbstractEntity;
import ru.basanov.model.Ad;
import ru.basanov.repository.AdRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;


@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(Object o) {
        entityManager.persist(o);
    }

    public <T> T merge(T t) {
        return entityManager.merge(t);
    }

    public void remove(Object o) {
        entityManager.remove(o);
    }

    public <S extends Ad> S save(S s) {
        return adRepository.save(s);
    }

    public <S extends Ad> Iterable<S> saveAll(Iterable<S> iterable) {
        return adRepository.saveAll(iterable);
    }

    public Optional<Ad> findById(String s) {
        return adRepository.findById(s);
    }

    public boolean existsById(String s) {
        return adRepository.existsById(s);
    }

    public Iterable<Ad> findAll() {
        return adRepository.findAll();
    }

    public Iterable<Ad> findAllById(Iterable<String> iterable) {
        return adRepository.findAllById(iterable);
    }

    public long count() {
        return adRepository.count();
    }

    public void deleteById(String s) {
        adRepository.deleteById(s);
    }

    public void delete(Ad ad) {
        adRepository.delete(ad);
    }

    public void deleteAll(Iterable<? extends Ad> iterable) {
        adRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        adRepository.deleteAll();
    }
}
