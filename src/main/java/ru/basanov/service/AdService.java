package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.Ad;
import ru.basanov.repository.AbstractRepository;
import ru.basanov.repository.AdRepository;
import sun.reflect.generics.repository.AbstractRepository;

import java.util.Optional;

@Service
@Transactional
public class AdService extends AbstractRepository implements AdRepository {

    @Autowired
    private AdRepository adRepository;

    @Override
    public void persist(Ad ad) {
        adRepository.persist(ad);
    }

    @Override
    public void merge(Ad ad) {
        adRepository.merge(ad);
    }

    @Override
    public void remove(Ad ad) {
        adRepository.remove(ad);
    }

    @Override
    public <S extends Ad> S save(S s) {
        return adRepository.save(s);
    }

    @Override
    public <S extends Ad> Iterable<S> saveAll(Iterable<S> iterable) {
        return adRepository.saveAll(iterable);
    }

    @Override
    public Optional<Ad> findById(String s) {
        return adRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return adRepository.existsById(s);
    }

    @Override
    public Iterable<Ad> findAll() {
        return entityManager.createNamedQuery("QUERY_FIND_ALL", Ad.class).getResultList();
    }

    @Override
    public Iterable<Ad> findAllById(Iterable<String> iterable) {
        return adRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return adRepository.count();
    }

    @Override
    public void deleteById(String s) {
        adRepository.deleteById(s);
    }

    @Override
    public void delete(Ad ad) {
        adRepository.delete(ad);
    }

    @Override
    public void deleteAll(Iterable<? extends Ad> iterable) {
        adRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        adRepository.deleteAll();
    }
}
