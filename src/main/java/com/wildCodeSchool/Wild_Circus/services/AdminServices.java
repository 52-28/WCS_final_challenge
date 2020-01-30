package com.wildCodeSchool.Wild_Circus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PresentationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PrestationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.StaffRepo;
import com.wildCodeSchool.Wild_Circus.entities.Staff;
import com.wildCodeSchool.Wild_Circus.pojo.StaffLists;

@Service
public class AdminServices implements IAdminServices {

	@Autowired
	CarouselRepo carouselRepo;
	
	@Autowired
	PresentationRepo presentationRepo;

	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	PrestationRepo prestationRepo;

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
		model.addObject("presentation",presentationRepo.findBySection("presentation"));
		
		return model;
	}
	
	@Override
	public ModelAndView getadminStaffModel() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("adminStaff");
		model.addObject("staffs",staffRepo.findAll());
		model.addObject("presentation",presentationRepo.findBySection("staff"));
		return model;
	}
	
	@Override
	public List<List<Staff>> parseStaffList(List<Staff> staffs) {
		
		List<List<Staff>> staffList = new ArrayList<List<Staff>>();
		List<Staff>tempoList = new ArrayList<Staff>();

		for (int i = 0 ; i <staffs.size()/2 + 1;i++) {
			tempoList = new ArrayList<Staff>();
			
			for (int j = i * 2; j<(i*2) + 2 && j <staffs.size(); j++) {
				tempoList.add(staffs.get(j));
			}	

			staffList.add(tempoList);
		}
		return staffList;
		
	}


	@Override
	public ModelAndView getadminPrestationModel() {

		ModelAndView model = new ModelAndView();
		model.setViewName("adminPrestation");
		model.addObject("prestations",prestationRepo.findAll());		
		return model;
	}
}
