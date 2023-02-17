package com.example.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.travels.models.Travel;
import com.example.travels.repositories.TravelRepository;

@Service
public class TravelService {
    
    @Autowired TravelRepository travelRepository;

    //create
    public void createTravel(Travel travel){
        travelRepository.save(travel);
    }

    //!READ ALL
    public List<Travel> allTravels(){
        return travelRepository.findAll();
    }

    //showOne!
    public Travel getOne(Long id){
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        return optionalTravel.orElse(null);
    }

    //updateone
    public void updateOne(Travel travel){
        travelRepository.save(travel);
    }

    //DELETE
    public void deleteById(Travel travel) {
        travelRepository.delete(travel);
    }

}
