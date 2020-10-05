package com.bionexo.geoubs.api.dto;

import com.bionexo.geoubs.model.entity.Ubs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UbsDTO {

	private Long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private String distance;
	private GeocodeDTO geocode;
	private ScoresDTO scores;
	
	
	public static UbsDTO converter(Ubs ubs) {
		
		return UbsDTO.builder()
					.id(ubs.getId())
					.name(ubs.getName())
					.address(ubs.getAddress())
					.city(ubs.getCity())
					.phone(ubs.getPhone())
					.distance(ubs.getDistancia())
					.geocode(new GeocodeDTO(ubs.getLatitude(), ubs.getLongitude()))
					.scores(new ScoresDTO(ubs.getAdaptation_for_seniors(), ubs.getMedical_equipment(), ubs.getMedicine()))
					.build();
					
	}
	
}

