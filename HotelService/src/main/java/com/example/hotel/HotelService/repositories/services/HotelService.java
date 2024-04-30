package com.example.hotel.HotelService.repositories.services;

import com.example.hotel.HotelService.Entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
