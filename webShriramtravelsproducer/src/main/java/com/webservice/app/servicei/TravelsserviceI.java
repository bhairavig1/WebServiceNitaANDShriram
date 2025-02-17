package com.webservice.app.servicei;

import java.util.List;

import com.webservice.app.model.Travels;

public interface TravelsserviceI 
{

	public void saveTravelsData(Travels t);

	public List<Travels> getAllTravelsData();

	public List<Travels> getSingleTravelsData(String fromLocation, String toLocation);

	public void updateTravelsData(Travels travels, int id);

	//public Travels getSingleTravelsData(String fromLocation, String toLocation);

	

}
