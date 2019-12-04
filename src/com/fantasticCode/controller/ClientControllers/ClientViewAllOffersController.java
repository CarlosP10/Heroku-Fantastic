package com.fantasticCode.controller.ClientControllers;

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
public class ClientViewAllOffersController extends SessionMethods {
	// Servicio que posee metodos de jpaRepository de OfferService.
	@Autowired
	OfferService offerService;

	// Controlador para acceder a las ofertas
	@RequestMapping(value = "/show_offers")
	public ModelAndView GeneralOffers(HttpSession session) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 2) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		List<Offer> offers = null;
		try {
			if (offerService.findAll() != null) {
				offers = offerService.findAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("ofertas", offers);
		mav.setViewName("public/offers");
		return mav;
	}

}
