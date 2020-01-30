package com.wildCodeSchool.Wild_Circus.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PresentationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PrestationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.StaffRepo;
import com.wildCodeSchool.Wild_Circus.entities.Prestation;

@Service
public class UtilServices implements IUtilServices {

	@Autowired
	CarouselRepo carouselRepo;
	@Autowired
	PresentationRepo presentationRepo;
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	IAdminServices adminService;
	
	@Autowired
	PrestationRepo prestationRepo;

	@Override
	public List<Prestation> searchForPrestation(String city) {
		List<Prestation> myList = new ArrayList<Prestation>();
		if (city != null) {
				myList = prestationRepo.findByCityContaining(city);				
			}
		else 
			throw new IllegalArgumentException("impossible de toruver des enregistrements sur variable null");
		return myList;
	}
	
	
}
