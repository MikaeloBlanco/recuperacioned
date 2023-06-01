package com.cpfifp.grijander.parkingfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkingfinalApplication {

	public static final int MAX_CAPACIDAD = 10;
	@Bean
	public static int getMaximaCapacidad() {
		return MAX_CAPACIDAD;
	}
	public static void main(String[] args) {
		SpringApplication.run(ParkingfinalApplication.class, args);
	}

}
