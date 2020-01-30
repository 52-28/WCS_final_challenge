package com.wildCodeSchool.Wild_Circus.services;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.entities.Staff;
import com.wildCodeSchool.Wild_Circus.pojo.StaffLists;

public interface IAdminServices {

	public ModelAndView getadminCarouselModel();
	
	public ModelAndView getadminPresentationModel() ;
	
	public ModelAndView getadminStaffModel();
	
	public List<List<Staff>> parseStaffList(List<Staff> staffs);
}
