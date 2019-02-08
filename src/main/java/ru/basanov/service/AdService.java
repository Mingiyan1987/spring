package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.Ad;
import ru.basanov.repository.AdRepository;

import java.util.List;

@Service
@Transactional
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public Ad findOne(String id) {
        if (id == null || id.isEmpty()) return null;
        return adRepository.findOne(id); }

    public List<Ad> findAll() {return adRepository.findAll();}

    public void removeById(String id) {
        if (id == null || id.isEmpty()) return;
        adRepository.removeById(id);
    }

    public Ad getAdById(String id) {
        return adRepository.getAdById(id);
    }

    public List<String> getListAdId() { return adRepository.getListAdId();}

    public List<Ad> getListAd() {
        return adRepository.getListAd();
    }

    public Long getCountAd() {
        return adRepository.getCountAd();
    }

    public void removeAll() {
        adRepository.removeAll();
    }
}
