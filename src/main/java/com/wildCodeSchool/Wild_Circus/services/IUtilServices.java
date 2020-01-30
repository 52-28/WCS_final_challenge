package com.wildCodeSchool.Wild_Circus.services;

import java.util.Date;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.wildCodeSchool.Wild_Circus.entities.Prestation;

public interface IUtilServices {

	public List<Prestation> searchForPrestation(String city);
}
