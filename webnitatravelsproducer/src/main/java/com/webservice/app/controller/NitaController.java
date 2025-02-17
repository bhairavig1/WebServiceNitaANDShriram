package com.webservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.app.model.Bus;
import com.webservice.app.servicei.ServiceInt;

@RestController
public class NitaController 
{
	@Autowired
	ServiceInt serviceInt;
	
	@PostMapping("/postdata")
	public String postData(@RequestBody Bus bus)
	{
		serviceInt.saveAllData(bus);
		
		return "Data Saved Successfully";
		
	}
	
	@GetMapping("/getall")
	public List<Bus> getAllData()
	{
		List<Bus> list =serviceInt.getAllBusData();
		
		return list;
		
	}
	
	@GetMapping("/getsingle/{id}")
	public Bus getSingleBus(@PathVariable int id)
	{
		
		Bus bus=serviceInt.getSingleBusData(id);
		
		return bus;
	}

	@PutMapping("/updateData/{id}")
	public String updateData(@RequestBody Bus bus,@PathVariable int id)
	{
		serviceInt.updateBusData(bus,id);
		
		return "Data Updated successfully";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id)
	{
		
		serviceInt.deleteBusData(id);
		
		return "data deleted successfully";
		
	}
	
	@DeleteMapping("/deleteAll")
	public String DeleteAllData()
	{
		
		serviceInt.deleteAllBusData();
		return "All Data Deleted";
	}
	
	@GetMapping("/getBus/{fromLocation}/{toLocation}")
	public List<Bus> getSingle(@PathVariable String toLocation, @PathVariable String fromLocation )
	{
			List<Bus> bus=serviceInt.getSingleBusData(fromLocation,toLocation);
		
		
		return bus;
		
	}
}
