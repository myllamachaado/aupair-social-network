package com.network.aupair.aupair;

import com.network.aupair.aupair.models.Aupair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AupairRepository extends JpaRepository<Aupair, String> {

}
