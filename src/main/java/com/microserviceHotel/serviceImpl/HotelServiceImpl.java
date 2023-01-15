package com.microserviceHotel.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserviceHotel.entity.Hotel;
import com.microserviceHotel.exceptions.AlreadyExistException;
import com.microserviceHotel.exceptions.ResourceNotFoundException;
import com.microserviceHotel.exceptions.ValidationException;
import com.microserviceHotel.repository.HotelRepository;
import com.microserviceHotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		Optional<Hotel> h = this.hotelRepo.findById(hotel.getHotelId());
		if (!h.isEmpty()) {
			throw new AlreadyExistException("Hotel", hotel.getHotelId());
		} else if (Integer.parseInt(hotel.getHotelId()) == 0) {
			throw new ValidationException("HotelId", "0");
		} else if (hotel.getHotelName().length() < 3) {
			throw new ValidationException("HotelName", "2");
		} else if (hotel.getHotelLocation().length() < 4) {
			throw new ValidationException("HotelLocation", "3");
		} else if (hotel.getHotelAbout() == null) {
			throw new ValidationException("HotelAbout", "0");
		}

		Hotel createdHotel = this.hotelRepo.save(hotel);
		return createdHotel;
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		if (Integer.parseInt(hotelId) == 0) {
			throw new ValidationException("HotelId", "0");
		}
		Hotel hotel = this.hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel", "HotelId", hotelId));
		return hotel;
	}

	@Override
	public List<Hotel> getHotels() {
		List<Hotel> hotels = this.hotelRepo.findAll();
		if (hotels.isEmpty()) {
			throw new ResourceNotFoundException("Hotels");
		}
		return hotels;
	}

	@Override
	public void deleteHotel(String hotelId) {
		this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "HotelId", hotelId));
		this.hotelRepo.deleteById(hotelId);
	}

}
