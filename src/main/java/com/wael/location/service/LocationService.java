package com.wael.location.service;

import java.util.List;

import com.wael.location.model.Location;

public interface LocationService {
	
	Location SaveLocation(Location location);
	Location UpdateLocation(Location location);
	void     Deletelocation(Location location);
	Location GetLocationById(int id);
	List<Location> GetAllLocation();

}
