package com.fantasticCode.controller.ClientControllers;

import javax.servlet.http.HttpSession;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
//Import para manejor de url dinamicas {id} .
import org.springframework.web.bind.annotation.PathVariable;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

//Import de entidad Offer.
import com.fantasticCode.entities.Offer;
//Import de servicio OfferService.
import com.fantasticCode.service.OfferService;

import UtilityMethods.SessionMethods;

//contolador para mostrar las ofertas
//el primer mapping es para mostrarlas en general
//el segundo mapping es para mostrarlas por id

@Controller
public class ClientViewSpecificOfferInformationController extends SessionMethods {
	// Servicio que posee metodos de jpaRepository de OfferService.
	@Autowired
	OfferService offerService;

	// Metodo que permite mostrar .jsp que permite mostrar la oferta especifica.
	@RequestMapping(value = "/show_offer/{id}")
	public ModelAndView OpenOffer(HttpSession session, @PathVariable(value = "id") int id) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 2) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		Offer offer = null;
		try {
			offer = offerService.findOne(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("specific_offer", offer);
		mav.setViewName("public/view_offer");
		return mav;
	}

}
