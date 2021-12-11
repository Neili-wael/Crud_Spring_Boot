package com.wael.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wael.location.model.Location;
import com.wael.location.repos.LocationRepository;
import com.wael.location.service.LocationService;
import com.wael.location.util.EmailUtil;


@Controller
public class LocationController {
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository Lr;
	
	@Autowired 
	EmailUtil Eu;
	
	
	@Autowired
	ServletContext Sc;
	
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return"CreateLocation";
	}
	
	@RequestMapping("/mou")
	public String displayloc(ModelMap modelMap) {
		
		List<Location> locations = service.GetAllLocation();
		modelMap.addAttribute("locations", locations);
	
		return "displayLocations";
		
	}
	@RequestMapping("deleteLocation")
	public String deletelocation(@RequestParam("id") int id , ModelMap modelMap) {
		Location location = service.GetLocationById(id);
		service.Deletelocation(location);
		List<Location> locations = service.GetAllLocation();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
     @RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMapd) {
		
		Location locationsaved = service.SaveLocation(location);
		String msg="location saved swith id = " + locationsaved.getId();
		modelMapd.addAttribute("msg",msg);
		Eu.sendEmai("neiliwael9@gmail.com", "Location saved", "Location saved successfully");
		return "CreateLocation";
		
	}
     
    @RequestMapping("EditLoc")
    public String showUpdate(@RequestParam("id") int id,ModelMap modelMap ) {
    	Location location = service.GetLocationById(id);
    	modelMap.addAttribute("location",location);
    	return "EditLocation";
    }
	
    @RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMapd) {
		 
    	service.UpdateLocation(location);
    	List<Location> locations = service.GetAllLocation();
    	modelMapd.addAttribute("locations",locations);
    	return "displayLocations";
		
	}
    


	}
