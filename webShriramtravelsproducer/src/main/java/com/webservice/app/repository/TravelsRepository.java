package com.webservice.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.model.Travels;

@Repository
public interface TravelsRepository extends CrudRepository<Travels, Integer>
{

   public List<Travels> findByFromLocationAndToLocation(String fromLocation, String toLocation);

	//Travels findByFromLocationAndToLocation(String fromLocation, String toLocation);

	
	
	
}
