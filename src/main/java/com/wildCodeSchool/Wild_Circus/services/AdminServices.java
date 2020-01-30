package com.wildCodeSchool.Wild_Circus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PresentationRepo;

@Service
public class AdminServices implements IAdminServices {

	@Autowired
	CarouselRepo carouselRepo;
	
	@Autowired
	PresentationRepo presentationRepo;

	@Override
	public ModelAndView getadminCarouselModel() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("adminCarousel");
		model.addObject("carousel",carouselRepo.findAll());
		
		return model;
	}
	

	@Override
	public ModelAndView getadminPresentationModel() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPresentation");
		model.addObject("presentation",presentationRepo.findById(1l).get());
		
		return model;
	}
}
