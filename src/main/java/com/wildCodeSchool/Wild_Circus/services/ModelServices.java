package com.wildCodeSchool.Wild_Circus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PresentationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.StaffRepo;
import com.wildCodeSchool.Wild_Circus.entities.Prestation;

@Service
public class ModelServices implements ImodelServices {

	@Autowired
	CarouselRepo carouselRepo;
	@Autowired
	PresentationRepo presentationRepo;
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	IAdminServices adminService;
	
	@Override
	public ModelAndView getHomeModel(List<Prestation> prestations) {

		ModelAndView model = new ModelAndView();
		if (prestations != null) {
			model.addObject("prestationsResult", prestations);
		}
		model.setViewName("index");
		model.addObject("carousel",carouselRepo.findAll());
		model.addObject("presentation", presentationRepo.findBySection("Presentation"));		
		model.addObject("staffPresentation",presentationRepo.findBySection("staff"));
		model.addObject("staffs", adminService.parseStaffList(staffRepo.findAll()));
		
		return model;
	}
}
