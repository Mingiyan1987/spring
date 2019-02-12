package ru.basanov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.model.Ad;

@Repository
public interface AdRepository extends CrudRepository<Ad, String> {

    void persist(Ad ad);

    void merge(Ad ad);

    void remove(Ad ad);
    
}
