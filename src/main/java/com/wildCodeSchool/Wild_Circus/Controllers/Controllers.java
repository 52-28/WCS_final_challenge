package com.wildCodeSchool.Wild_Circus.Controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PresentationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.PrestationRepo;
import com.wildCodeSchool.Wild_Circus.Repositories.StaffRepo;
import com.wildCodeSchool.Wild_Circus.entities.Carousel;
import com.wildCodeSchool.Wild_Circus.entities.Presentation;
import com.wildCodeSchool.Wild_Circus.entities.Prestation;
import com.wildCodeSchool.Wild_Circus.entities.Staff;
import com.wildCodeSchool.Wild_Circus.services.IAdminServices;
import com.wildCodeSchool.Wild_Circus.services.IUtilServices;
import com.wildCodeSchool.Wild_Circus.services.ImodelServices;
import com.wildCodeSchool.Wild_Circus.services.ModelServices;

@Controller
public class Controllers {

	@Autowired
	ImodelServices modelServices;

	@Autowired
	IAdminServices adminServices;
	
	@Autowired
	CarouselRepo carouselRepo;
	
	@Autowired
	PresentationRepo presentationRepo;
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	PrestationRepo prestationRepo;
	
	@Autowired
	IUtilServices utilServices;
	
	@GetMapping("/")
	public ModelAndView gethome(@RequestParam(value="prestationsResult", required=false) List<Prestation> prestationsResult) {
		System.out.println(prestationsResult == null);
		return modelServices.getHomeModel(prestationsResult);
	}
	
	@GetMapping("/searchForPrestation")
	public ModelAndView searchForPrestation(@RequestParam(value = "city", required=true) String city) {
		ModelMap model = new ModelMap();		
		List<Prestation> prestationsResult = utilServices.searchForPrestation(city);
		model.addAttribute("prestationsResult", prestationsResult);
		System.out.println(prestationsResult.size());
		return modelServices.getHomeModel(prestationsResult);
	}

	@GetMapping("/admin")
	public ModelAndView getAdmin() {
		return new ModelAndView("admin");
	}
	
	@PostMapping("/postReservation")
	public ModelAndView postForReservation(@ModelAttribute Long prestationId) {
		return null;
	}
	
	@GetMapping("/admin/carousel")
	public ModelAndView getAdminCarousel() {
		
		return adminServices.getadminCarouselModel();
	}
	
	@GetMapping("/admin/presentation")
	public ModelAndView getAdminPresentation() {
		
		return adminServices.getadminPresentationModel();
	}
	
	@GetMapping("/admin/equipe")
	public ModelAndView getAdminStaff() {
		
		return adminServices.getadminStaffModel();
	}
	
	@GetMapping("/admin/prestation")
	public ModelAndView getAdminPrestation() {
		
		return adminServices.getadminPrestationModel();
	}
	
	@PostMapping("/admin/prestation/create")
	public ModelAndView postAdminPrestation(@ModelAttribute Prestation prestation) {
		
		prestationRepo.save(prestation);
		return new ModelAndView("redirect:/admin/prestation");
	}
	
	@PostMapping("/admin/staff/create")
	public ModelAndView postAdminStaff(@ModelAttribute Staff staff) {
	
		staffRepo.save(staff);
		return new ModelAndView("redirect:/admin/equipe");
	}
	
	@PostMapping("/admin/staff/delete")
	public ModelAndView deleteAdminStaff(@RequestParam Long id) {
	
		staffRepo.deleteById(id);
		return new ModelAndView("redirect:/admin/equipe");
	}
	
	@PostMapping("/admin/presentation/update")
	public ModelAndView postAdminPresentation(@ModelAttribute Presentation presentation) {
		
		presentationRepo.save(presentation);
		return new ModelAndView("redirect:/admin/presentation");
	}
	
	@PostMapping("/admin/carousel/create")
	public ModelAndView postCarouselItem(@ModelAttribute Carousel carousel) {
		
		carouselRepo.save(carousel);
		return new ModelAndView("redirect:/admin/carousel");
	}

	@PostMapping("/admin/carousel/edit")
	public ModelAndView editCarouselItem(@ModelAttribute Carousel carousel) {
		
		carouselRepo.save(carousel);
		return new ModelAndView("redirect:/admin/carousel");
	}
	
	@PostMapping("/admin/carousel/delete")
	public ModelAndView postCarouselItem(@RequestParam Long id) {
		
		carouselRepo.delete(carouselRepo.getOne(id));
		return new ModelAndView("redirect:/admin/carousel");
	}
}
