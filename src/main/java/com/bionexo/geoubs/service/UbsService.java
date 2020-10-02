package com.bionexo.geoubs.service;

import java.util.List;

import com.bionexo.geoubs.model.entity.Ubs;

public interface UbsService {

	List<Ubs> getNearUbs(String latitude, String longitude, Integer page, Integer per_page);
	Long getTotalUbs();
	
}
