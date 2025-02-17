package com.webservice.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.app.model.BusNS;
import com.webservice.app.repository.ConRepository;
import com.webservice.app.serviceInt.ConServiceInt;

@Service
public class ConServiceImpl implements ConServiceInt
{
	@Autowired
	ConRepository cr;
//
//	@Override
//	public List<BusNS> getAllProduceData( String toLocation, String fromLocation) 
//	{
//
//		return cr.findAllByFromLocationToLocation(fromLocation,toLocation);
//	 
//	}
//	

	@Override
	public void save(BusNS li2) 
	{
		cr.save(li2);
		
	}
	
	
}
