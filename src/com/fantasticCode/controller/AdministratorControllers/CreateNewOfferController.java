package com.fantasticCode.controller.AdministratorControllers;

//Import para utilizar listas.
import java.util.List;

import javax.servlet.http.HttpSession;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Offer_type;
import com.fantasticCode.service.Offer_type_Service;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class CreateNewOfferController extends SessionMethods {

	@Autowired
	private Offer_type_Service offer_type_Service;

	// controlador de crear ofertas (administrador)

	@RequestMapping(value = "/admin/new_offer")
	public ModelAndView GenerateNewOfferView(HttpSession session) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Offer_type> offer_type_list = null;
		try {
			if (offer_type_Service.findAll() != null) {
				offer_type_list = offer_type_Service.findAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("offer_type_list", offer_type_list);
		mav.setViewName("admin/offers/new_offer");
		return mav;
	}
}
