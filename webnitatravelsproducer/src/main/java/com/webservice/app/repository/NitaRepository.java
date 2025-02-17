package com.webservice.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.model.Bus;

@Repository
public interface NitaRepository extends CrudRepository<Bus, Integer>
{

	public List<Bus> findByFromLocationAndToLocation(String fromLocation, String toLocation);
		//save and finnByID, FindAll, deleteById are in build methods in crud repositotry so no need to 
	//write here...
	
}
