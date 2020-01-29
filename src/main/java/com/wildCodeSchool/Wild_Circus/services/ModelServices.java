package com.wildCodeSchool.Wild_Circus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;

@Service
public class ModelServices implements ImodelServices {

	@Autowired
	CarouselRepo carouselRepo;
	
	@Override
	public ModelAndView getHomeModel() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("carousel",carouselRepo.findAll());
		
		return model;
	}
}
