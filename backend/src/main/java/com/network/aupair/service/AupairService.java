package com.network.aupair.service;

import com.network.aupair.repository.AupairRepository;
import com.network.aupair.models.Aupair;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AupairService {

    private final AupairRepository aupairRepository;

    public AupairService(AupairRepository aupairRepository) {
        this.aupairRepository = aupairRepository;
    }

    @Transactional
    public Aupair save(Aupair aupair){
        return aupairRepository.save(aupair);
    }

    public List<Aupair> list(){
        return aupairRepository.findAll();
    }

    public Aupair getById(String id){
        return aupairRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public Aupair updateById(Aupair aupair, String id){
        aupair.setAupairId(id);
        return this.save(aupair);
    }

    @Transactional
    public void delete(String id){
        this.getById(id);
        aupairRepository.deleteById(id);
    }

}
