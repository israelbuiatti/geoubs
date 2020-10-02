package com.bionexo.geoubs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bionexo.geoubs.model.entity.Ubs;
import com.bionexo.geoubs.model.repository.UbsRepository;
import com.bionexo.geoubs.service.UbsService;

@Service
public class UbsServiceImpl implements UbsService {
	
	private UbsRepository repository;
	
	public UbsServiceImpl(UbsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Ubs> getNearUbs(String latitude, String longitude, Integer page, Integer per_page) {
		
		List<Ubs> lista = repository.getNearUbs(latitude, longitude, page, per_page);

		return lista;
	}
	
	@Override
	public Long getTotalUbs() {
		
		Long count = repository.count();

		return count;
	}

}
