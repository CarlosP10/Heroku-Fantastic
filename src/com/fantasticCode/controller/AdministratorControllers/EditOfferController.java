package com.fantasticCode.controller.AdministratorControllers;

//Import para utilizar listas.
import java.util.List;

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
import com.fantasticCode.entities.Offer_type;
//Import de servicio OfferService.
import com.fantasticCode.service.OfferService;
import com.fantasticCode.service.Offer_type_Service;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class EditOfferController extends SessionMethods {

	@Autowired
	private Offer_type_Service offer_type_Service;
	@Autowired
	private OfferService offerService;
	// controlador de editar ofertas (administrador)

	@RequestMapping(value = "/admin/edit_offer/{id}")
	public ModelAndView EditOfferView(HttpSession session, @PathVariable(value = "id") int id) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		Offer offer = null;
		List<Offer_type> offer_type_list = null;
		try {
			if (offer_type_Service.findAll() != null)
				offer_type_list = offer_type_Service.findAll();

			if (offer_type_Service.findAll() != null)
				offer = offerService.findOne(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mav.addObject("offer", offer);
		mav.addObject("offer_type_list", offer_type_list);
		mav.setViewName("admin/offers/edit_offer");
		return mav;
	}
}
