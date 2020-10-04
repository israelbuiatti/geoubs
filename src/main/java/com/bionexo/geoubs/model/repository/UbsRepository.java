package com.bionexo.geoubs.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionexo.geoubs.model.entity.Ubs;

public interface UbsRepository extends JpaRepository<Ubs, Long> {
	
	@Query(value = "select * from ("
						+ "	select "
						+ "	(acos(sin(radians(u.vlr_latitude)) * sin(radians(?1)) +"
						+ "	cos(radians(u.vlr_latitude)) * cos(radians(?1)) *"
						+ "	cos(radians(u.vlr_longitude ) - radians(?2))) * 6378) as distancia"
						+ "	,u.* from zij7j69kbjhdj2tf.ubs u"
					+ " ) c1"
					+ " order by distancia limit ?4 offset ?3 ",nativeQuery = true)
	List<Ubs> getNearUbs(String latitude, String longitude, Integer page, Integer per_page);
	
}
