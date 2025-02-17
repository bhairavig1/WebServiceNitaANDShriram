package com.webservice.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.app.model.Bus;
import com.webservice.app.repository.NitaRepository;
import com.webservice.app.servicei.ServiceInt;

@Service
public class ServiceImpl implements ServiceInt
{
	@Autowired
	NitaRepository nitaRepository;

	@Override
	public void saveAllData(Bus bus) 
	{

		nitaRepository.save(bus);
	}

	@Override
	public List<Bus> getAllBusData()
	{
		
		
		return (List<Bus>) nitaRepository.findAll();
	}

	@Override
	public Bus getSingleBusData(int id) 
	{
		Optional<Bus> op= nitaRepository.findById(id);
		
			if(op.isPresent())
			{
				Bus bb=op.get();
				
				return bb;
			}
			else
			{
			return null;
			}

	}

	@Override
	public void updateBusData(Bus bus,int id)
	{
		Optional<Bus> op= nitaRepository.findById(id);
		
		if(op.isPresent())
		{
			Bus bb=op.get();
			
			bb.setBusNumber(bus.getBusNumber());
			bb.setBusName(bus.getBusName());
			bb.setFromLocation(bus.getFromLocation());
			bb.setToLocation(bus.getToLocation());
			bb.setDate(bus.getDate());
			bb.setPrice(bus.getPrice());
			bb.setTimings(bus.getTimings());
			
			nitaRepository.save(bb);
		}
	
		else
		{
			nitaRepository.save(bus);
		}
	
	}

	@Override
	public void deleteBusData(int id) 
	{

		nitaRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllBusData() 
	{

		nitaRepository.deleteAll();
	}

	@Override
	public List<Bus> getSingleBusData(String fromLocation, String toLocation) 
	{
	
		return nitaRepository.findByFromLocationAndToLocation(fromLocation,toLocation);
	}
	
}
