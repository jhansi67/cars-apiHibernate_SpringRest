package com.rest.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.api.model.Car;

@RequestMapping("/car")
public class CarResource {

	@GetMapping("{registraionId}")
	public Car getCarDetails(@PathParam("registraionId") String regitrationId) {
		System.out.println("getCarDetails...>");
		return new Car(regitrationId, "RD520");
	}

}
