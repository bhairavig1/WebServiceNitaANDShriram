package com.webservice.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.app.model.Travels;
import com.webservice.app.repository.TravelsRepository;
import com.webservice.app.servicei.TravelsserviceI;

@Service
public class TravelServiceImpl implements TravelsserviceI{

	@Autowired
	TravelsRepository tr;

	@Override
	public void saveTravelsData(Travels t)
	{

			tr.save(t);
			
	}

	@Override
	public List<Travels> getAllTravelsData() 
	{
		List<Travels> al=(List<Travels>) tr.findAll();
		return al;
	}

	@Override
	public List<Travels> getSingleTravelsData(String fromLocation, String toLocation) 
	{
		return tr.findByFromLocationAndToLocation(fromLocation, toLocation);
	}

	@Override
	public void updateTravelsData( Travels travels,int id) 
	{
		Optional<Travels>op = tr.findById(id);
		
			if(op.isPresent())
			{
					Travels tt=op.get();
				
						tt.setTimings(travels.getTimings());
			}
		
	}

//	@Override
//	public Travels getSingleTravelsData(String fromLocation, String toLocation) 
//	{
//		return tr.findByFromLocationAndToLocation(fromLocation, toLocation);
//	
//	}
//	
}
