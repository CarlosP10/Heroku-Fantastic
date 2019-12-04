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

//Import de entidad Offer.
import com.fantasticCode.entities.Offer;
//Import de servicio OfferService.
import com.fantasticCode.service.OfferService;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class AdminViewAllOffersController extends SessionMethods {

	@Autowired
	private OfferService offerService;
	// controlador de ver ofertas (administrador)

	@RequestMapping(value = "/admin/view_offers")
	public ModelAndView ViewOffers(HttpSession session) {
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Offer> offer_list = null;
		try {
			if (offerService.findAll() != null) {
				offer_list = offerService.findAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("offer_list", offer_list);
		mav.setViewName("/admin/offers/view_offers");
		return mav;
	}

}
