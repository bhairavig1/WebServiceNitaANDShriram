package com.webservice.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.model.BusNS;

@Repository
public interface ConRepository extends CrudRepository<BusNS, Integer>
{

	//List<BusNS> findAllByFromLocationToLocation(String fromLocation, String toLocation);
	
	
	
	
}
