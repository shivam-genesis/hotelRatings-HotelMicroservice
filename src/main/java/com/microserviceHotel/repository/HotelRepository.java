package com.microserviceHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microserviceHotel.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>{

}
