package com.bionexo.geoubs.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.geoubs.api.dto.ResponseDTO;
import com.bionexo.geoubs.api.dto.UbsDTO;
import com.bionexo.geoubs.exception.RegraNegocioException;
import com.bionexo.geoubs.model.entity.Ubs;
import com.bionexo.geoubs.service.UbsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UbsController {

	private final UbsService service;
	
	@GetMapping("/find_ubs")
	public ResponseEntity<ResponseDTO> getUbs(
				@RequestParam String query,
				@RequestParam(required = false, value="page") String pageStr,
				@RequestParam(required = false, value="per_page") String per_pageStr
			) {
		
		//default
		if (pageStr == null || pageStr.isEmpty()) pageStr = "1";
		if (per_pageStr == null || per_pageStr.isEmpty()) per_pageStr = "10";
		
		
		Integer page, per_page;
		
		try {
			page = Integer.valueOf(pageStr);
		} catch (Exception e) {
			throw new RegraNegocioException("O Parâmetro page deve ser um inteiro");
		}
		
		try {
			per_page = Integer.valueOf(per_pageStr);
		} catch (Exception e) {
			throw new RegraNegocioException("O Parâmetro per_page deve ser um inteiro");
		}
		
		List<String> coords = Stream.of(query.split(",")).map (elem -> new String(elem).trim()).collect(Collectors.toList());
		
		if (coords.size() != 2) {
			throw new RegraNegocioException("Coordenadas inválidas");
		}

		
		List<Ubs> lista = service.getNearUbs(coords.get(0), coords.get(1), page, per_page);
		Long count 		= service.getTotalUbs();
		
		ResponseDTO response = ResponseDTO.builder()
					.current_page(page)
					.per_page(per_page)
					.total_entries(count)
					.entries(lista.stream().map( n -> UbsDTO.converter(n) ).collect(Collectors.toList()) )
					.build();
		
		return ResponseEntity.ok(response);
		
	}
	

}
