package com.microserviceHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
	@Id
	@Column(name = "ID")
	private String hotelId;
	@Column(name = "NAME")
	private String hotelName;
	@Column(name = "LOCATION")
	private String hotelLocation;
	@Column(name = "ABOUT")
	private String hotelAbout;
}
