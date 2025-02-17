package com.webservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.app.model.Travels;
import com.webservice.app.servicei.TravelsserviceI;

@RestController
public class ProController 
{
	@Autowired
	TravelsserviceI tsi;
	
	@PostMapping("/addData")
	public String addData(@RequestBody Travels t)
	{
		tsi.saveTravelsData(t);
		
		return "Data Saved Successfully";
		
	}
	
	@GetMapping("/getalldata")
	public List<Travels> getAllData()
	{
		System.out.println("getALLData method ");
		
		List<Travels> li=tsi.getAllTravelsData();
		
		return li;
		
	}
	@GetMapping("/getSingleTravels/{fromLocation}/{toLocation}")
	public List<Travels> getSingle(@PathVariable String toLocation, @PathVariable String fromLocation )
	{
			List<Travels> tt=tsi.getSingleTravelsData(fromLocation,toLocation);
		
		
		return tt;
		
	}
	
	@PutMapping("/updatetra/{id}")
	public String updateTravel(@RequestBody Travels travels,@PathVariable int id)
	{
		tsi.updateTravelsData(travels,id);
		
		return "data updated";
		
		
	}
}
