package com.example.hotel.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.HotelService.Entities.Hotel;


public interface HotelRepository extends JpaRepository<Hotel,String>{

}
