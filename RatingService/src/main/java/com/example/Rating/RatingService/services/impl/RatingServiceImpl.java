package com.example.Rating.RatingService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rating.RatingService.Repositories.RatingRepository;
import com.example.Rating.RatingService.entities.Rating;
import com.example.Rating.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
    //for above override we custom finder method in repositories as we created it 
    //while as  save and findall are inbuild 
    //so they do not require any custom method to be mentioned in repositories
}
