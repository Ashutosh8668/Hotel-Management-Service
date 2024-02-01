package com.example.user.service.UserService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.service.UserService.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
//Openfeign dependecy require for it which help for dynamic implementation of an interface that ie 
//port can be change for that we require a dynamic http link 
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

   
}
