package com.wildCodeSchool.Wild_Circus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.entities.Prestation;

public interface ImodelServices {

	public ModelAndView getHomeModel(List<Prestation> prestations);
}
