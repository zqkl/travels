package com.example.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.travels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel,Long> {
    List<Travel> findAll();
    
}
