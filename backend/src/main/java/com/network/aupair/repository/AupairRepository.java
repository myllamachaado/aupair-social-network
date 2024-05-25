package com.network.aupair.repository;

import com.network.aupair.models.Aupair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AupairRepository extends JpaRepository<Aupair, String> {

}
