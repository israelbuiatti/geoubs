package com.bionexo.geoubs.api.resource;

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
import com.bionexo.geoubs.model.entity.Ubs;
import com.bionexo.geoubs.service.UbsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UbsResource {

	private final UbsService service;
	
	@GetMapping("/find_ubs")
	public ResponseEntity<ResponseDTO> getUbs(
				@RequestParam String query,
				@RequestParam(required = false) Integer page,
				@RequestParam(required = false) Integer per_page
			) {
		
		if (page == null) page = 1;
		if (per_page == null) per_page = 10;
		
		List<String> coords = Stream.of(query.split(",")).map (elem -> new String(elem).trim()).collect(Collectors.toList());
		
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
