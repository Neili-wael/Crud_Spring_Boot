package com.wael.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wael.location.model.Location;
import com.wael.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class locationRestController {
	@Autowired
	LocationRepository Lr;
	
	
	@GetMapping("/All")
	public List<Location> getAllLocations(){
		return Lr.findAll();
		}
	@GetMapping("/location/{id}")
	public Location getLocation(@PathVariable int id ) {
		
		Optional<Location> location = Lr.findById(id);
		return location.get();
	}
	@PostMapping("/location")
	public Location createLocation(@RequestBody Location location) {
		Location loc = Lr.save(location);
		return loc;
		
		
	}
	@PutMapping("/location") 
	public Location updateLocation(@RequestBody Location location) {
		Location loc = Lr.save(location);
		return loc;
	}
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable int id) {
		
		 Lr.deleteById(id);
	}
}
