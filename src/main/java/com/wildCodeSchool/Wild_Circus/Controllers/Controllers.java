package com.wildCodeSchool.Wild_Circus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.services.ImodelServices;
import com.wildCodeSchool.Wild_Circus.services.ModelServices;

@Controller
public class Controllers {

	@Autowired
	ImodelServices modelServices;
	
	@GetMapping("/admin")
	public ModelAndView getAdmin() {
		return new ModelAndView("admin");
	}

	@GetMapping("/")
	public ModelAndView gethome() {
		
		return modelServices.getHomeModel();
	}
	
	@GetMapping("/admin/carousel")
	public ModelAndView getAdminCarousel() {
		return new ModelAndView("adminCarousel");
	}
}
