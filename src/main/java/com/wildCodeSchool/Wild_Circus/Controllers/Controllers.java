package com.wildCodeSchool.Wild_Circus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.Repositories.CarouselRepo;
import com.wildCodeSchool.Wild_Circus.entities.Carousel;
import com.wildCodeSchool.Wild_Circus.services.IAdminServices;
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
	
	@GetMapping("/")
	public ModelAndView gethome() {
		
		return modelServices.getHomeModel();
	}

	@GetMapping("/admin")
	public ModelAndView getAdmin() {
		return new ModelAndView("admin");
	}
	
	@GetMapping("/admin/carousel")
	public ModelAndView getAdminCarousel() {
		
		return adminServices.getadminCarouselModel();
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
