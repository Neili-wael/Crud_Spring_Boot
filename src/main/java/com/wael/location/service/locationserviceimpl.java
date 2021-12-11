package com.wael.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wael.location.model.Location;
import com.wael.location.repos.LocationRepository;

@Service
public class locationserviceimpl implements LocationService {
	
	@Autowired
	private LocationRepository Lr;

	public LocationRepository getLr() {
		return Lr;
	}

	public void setLr(LocationRepository lr) {
		Lr = lr;
	}

	@Override
	public Location SaveLocation(Location location) {
		return Lr.save(location);
	}

	@Override
	public Location UpdateLocation(Location location) {
		return Lr.save(location);
		}

	@Override
	public void Deletelocation(Location location) {
			Lr.delete(location);
	}

	@Override
	public Location GetLocationById(int id) {
			Optional<Location> L= Lr.findById(id);
			Location loc =L.get();
			return loc;
			
	}

	@Override
	public List<Location> GetAllLocation() {
			return Lr.findAll();
	}

}
