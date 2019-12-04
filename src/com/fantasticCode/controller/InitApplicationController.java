package com.fantasticCode.controller;

//Import para el manejor de sesiones.
import javax.servlet.http.HttpSession;

//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class InitApplicationController extends SessionMethods {

	// Metodo para mostrar Login, se verifican los atributos y roles.
	@RequestMapping(value = "/")
	public ModelAndView initMain(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// Metodo de SessionMethods que redirecciona a las paginas segun su rol.
		mav = sessionverification(session);
		return mav;
	}

}
