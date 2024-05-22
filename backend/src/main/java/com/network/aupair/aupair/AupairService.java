package com.network.aupair.aupair;

import com.network.aupair.aupair.models.Aupair;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Aupair> getById(String id){
        return aupairRepository.findById(id);
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
