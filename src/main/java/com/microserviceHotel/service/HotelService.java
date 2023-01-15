package com.microserviceHotel.service;

import java.util.List;

import com.microserviceHotel.entity.Hotel;

public interface HotelService {
	Hotel createHotel(Hotel hotel);

	Hotel getHotelById(String hotelId);

	List<Hotel> getHotels();
	
	void deleteHotel(String hotelId);

}
