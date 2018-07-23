package com.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Person;

@RestController
@RequestMapping("/person")
public class PersonResource {

	public PersonResource() {
		System.out.println("PersonResource...");
	}

	@GetMapping("/{id}")
	public Person getPersonDetails(@PathVariable("id") Long id) {
		System.out.println("Get Person Details..");
		return new Person(id, "Default");
	}

	@GetMapping("/{id}/car/{registraionId}")
	public String getCarDetails(@PathVariable("id") Long id, @PathVariable("registraionId") String registraionId) {
		System.out.println("attempts to Subresource..");
		return "redirect:"+id + "/car/" + registraionId;
	}

}
