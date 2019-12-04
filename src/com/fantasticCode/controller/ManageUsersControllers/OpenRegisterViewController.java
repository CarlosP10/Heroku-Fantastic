package com.fantasticCode.controller.ManageUsersControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.entities.Municipio;
import com.fantasticCode.entities.Countries;
import com.fantasticCode.service.AccountService;
import com.fantasticCode.service.MunicipalityService;
import com.fantasticCode.service.CountryService;
import com.fantasticCode.service.UserService;


@Controller
public class OpenRegisterViewController {
	
    @Autowired
    CountryService paisService;@Autowired
    MunicipalityService municipioService;
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mav =new ModelAndView();
		List<Municipio> municipalities=municipioService.findAll();
		List<Countries> paises=paisService.findAll();
		mav.addObject("municipalities", municipalities);
		mav.addObject("countries", paises);
		mav.setViewName("user/register");
		return mav;
	}
	
	
}