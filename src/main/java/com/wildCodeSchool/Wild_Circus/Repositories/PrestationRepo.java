package com.wildCodeSchool.Wild_Circus.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildCodeSchool.Wild_Circus.entities.Prestation;


@Repository
public interface PrestationRepo extends JpaRepository<Prestation, Long>{

	public List<Prestation> findByCityContaining(String city);
	public List<Prestation> findByRepresentationDate(Date searchForDate);
	public List<Prestation> findByRepresentationDateAndCityContaining(Date searchForDate, String city);
}
