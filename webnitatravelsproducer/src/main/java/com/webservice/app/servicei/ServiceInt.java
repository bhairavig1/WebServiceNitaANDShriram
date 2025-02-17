package com.webservice.app.servicei;

import java.util.List;

import com.webservice.app.model.Bus;

public interface ServiceInt {

	public void saveAllData(Bus bus);

	public List<Bus> getAllBusData();

	public Bus getSingleBusData(int id);

	public void updateBusData(Bus bus, int id);

	public void deleteBusData(int id);

	public void deleteAllBusData();

	public List<Bus> getSingleBusData(String fromLocation, String toLocation);



}
