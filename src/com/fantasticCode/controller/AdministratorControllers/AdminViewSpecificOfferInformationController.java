package com.fantasticCode.controller.AdministratorControllers;

import javax.servlet.http.HttpSession;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
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

//Controlador para manipulacion de ModelandViews.
@Controller
public class AdminViewSpecificOfferInformationController extends SessionMethods {

	@Autowired
	private OfferService offerService;
	// controlador de ver ofertas por id (administrador)

	@RequestMapping(value = "/admin/view_offer/{id}"/* , method = RequestMethod.POST */)
	public ModelAndView ViewOffer(HttpSession session, @PathVariable(value = "id") int id) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		Offer offer = null;
		try {
			offer = offerService.findOne(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("offer", offer);
		mav.setViewName("admin/offers/view_offer");
		return mav;
	}

}
