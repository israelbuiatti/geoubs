package com.bionexo.geoubs.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO {
	
	private Integer current_page;
	private Integer per_page;
	private Long total_entries;
	private List<UbsDTO> entries;
	
}
