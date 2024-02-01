package com.example.Rating.RatingService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Rating.RatingService.entities.Rating;
//while dealing with relational database we JPAREPOSITORY 
public interface RatingRepository extends MongoRepository<Rating,String>
{
	 //custom finder methods
	 //as findBy___ we write our column-name in camel-case
	    List<Rating> findByUserId(String userId);
	    List<Rating> findByHotelId(String hotelId);
}