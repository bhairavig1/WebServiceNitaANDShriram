package com.webservice.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.app.model.BusNS;
import com.webservice.app.serviceInt.ConServiceInt;

@RestController
public class ConConsumer 
{

	@Autowired
	RestTemplate rt;
	
	@Autowired
	ConServiceInt conServiceInt;
	
	@GetMapping("/getAllBus")
	public List<List<BusNS>> getAllBusData()
	{
//		String shriramurl= "http://localhost:9998/getalldata";// shriram travels
//		
//		List list=rt.getForObject(shriramurl, List.class);	
//		
//		String nitaurl="http://localhost:9094/getall";	//nita bus
//		
//		List list2= rt.getForObject(nitaurl, List.class);
//		
//	
//		
//		List<List<BusNS>> bus= new ArrayList<List<BusNS>>();
//		
//				bus.add(list);
//				bus.add(list2);
//				
//				System.out.println(bus);
		
				
		
		
String shriramurl= "http://localhost:9998/getalldata";// shriram travels
		
		BusNS[] list=rt.getForObject(shriramurl, BusNS[].class);	
		
		String nitaurl="http://localhost:9094/getall";	//nita bus
		
		BusNS[] list2= rt.getForObject(nitaurl, BusNS[].class);
		
	List<BusNS> li= new ArrayList<BusNS>(Arrays.asList(list));
	List<BusNS> li2= new ArrayList<BusNS>(Arrays.asList(list2));
		
		List<List<BusNS>> bus= new ArrayList<List<BusNS>>();
		
				bus.add(li);
				bus.add(li2);
				
				System.out.println(bus);
		
//		
				Iterator<List<BusNS>> itr= bus.iterator();
				
					while(itr.hasNext())
					{
						List<BusNS> buslist =itr.next();
						
						Iterator<BusNS> itr1= buslist.iterator();
						
							while(itr1.hasNext())
							{
								
								BusNS ns= itr1.next();
								
								System.out.println(ns);
								
							}
						}
	
		return bus;
		
	}
	
	
	@PostMapping("/saveall")
	public String saveAllBus()
	{
		
		
		String urlshriram= "http://localhost:9998/getalldata";
		
		BusNS[] busram= rt.getForObject(urlshriram, BusNS[].class);
		
		String urlnita= "http://localhost:9094/getall";
		
		BusNS[] busnita= rt.getForObject(urlnita, BusNS[].class);
		
		
		List<BusNS> al= new ArrayList<BusNS>(Arrays.asList(busram));
		List<BusNS> al2= new ArrayList<BusNS>(Arrays.asList(busnita));
		
		List<List<BusNS>> list= new ArrayList<List<BusNS>>();
		
		list.add(al);
		list.add(al2);
		
		System.out.println(list);
		
		for(List<BusNS> li1: list)
		{
				for(BusNS li2 : li1)
				{
					conServiceInt.save(li2);
					
				}
			
			
			
		}
 		
		return "all Data saved";
		
		
	}
	
	
	
//	
//	@GetMapping("/getallproduce/{fromLocation}/{toLocation}")
//	public List<BusNS> getAllProduce( @PathVariable String fromLocation,
//			@PathVariable String toLocation)
//	{
//		String url= ""
//		
//		
//		
//		List <BusNS> list=conServiceInt.getAllProduceData(toLocation,fromLocation);
//		
//		return list;
	//}
	
}
