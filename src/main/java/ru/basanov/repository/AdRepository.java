package ru.basanov.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.model.Ad;

import javax.persistence.PersistenceContext;

@Repository
public interface AdRepository extends CrudRepository<Ad, String> {
}
