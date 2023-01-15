package com.microserviceHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceHotel.entity.Hotel;
import com.microserviceHotel.exceptions.ApiResponse;
import com.microserviceHotel.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel h = this.hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(h, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
		Hotel h = this.hotelService.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(h, HttpStatus.OK);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> hotels = this.hotelService.getHotels();
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String hotelId) {
		this.hotelService.deleteHotel(hotelId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Hotel Deleted!!", true), HttpStatus.OK);
	}
}
