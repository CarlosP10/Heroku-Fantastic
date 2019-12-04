package com.fantasticCode.controller.AdministratorControllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para uso de metodos GET POST.
import org.springframework.web.bind.annotation.RequestMethod;
//Import para obtener parametros desde .jsp.
import org.springframework.web.bind.annotation.RequestParam;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

//Import de entidad Offer.
import com.fantasticCode.entities.Offer;
//Import de servicio OfferService.
import com.fantasticCode.service.OfferService;
import com.fantasticCode.service.Offer_type_Service;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class SaveUpdatedOfferController extends SessionMethods {

	@Autowired
	private Offer_type_Service offer_type_Service;
	@Autowired
	private OfferService offerService;
	// Controlador para guardar las ofertas modificadas (administrador)

	@RequestMapping(value = "/admin/save_edit_offer/{id}", method = RequestMethod.POST)
	public ModelAndView SaveEditOfferRedirection(HttpSession session, @PathVariable(value = "id") int id,
			@RequestParam String offername, @RequestParam String description, @RequestParam String urlposter,
			@RequestParam int availability, @RequestParam String startdate, @RequestParam String enddate,
			@RequestParam String offer_code, @RequestParam int offer_state, @RequestParam float price_range,
			@RequestParam int type) {
		redirectSession(session);
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		Offer offer = null;
		if (offerService.findOne(id) != null) {
			offer = offerService.findOne(id);
			offer.setOffername(offername);
			offer.setDescription(description);
			offer.setUrlposter(urlposter);
			offer.setAvailability(availability);
			Date start_d = null;
			Date end_d = null;
			Date now = null;
			try {
				start_d = formatDate(startdate);
				end_d = formatDate(enddate);
				now = formatDate(obtainActualDate());
			} catch (Exception e) {
			}
			offer.setStartdate(start_d);
			offer.setEnddate(end_d);
			offer.setDuration(end_d.getTime() - start_d.getTime() + "");
			offer.setOffer_code(offer_code);
			offer.setOffer_state(offer_state);
			offer.setPrice_range(price_range);
			offer.setCreation_date_hour(now);
			// offer.setDuration(enddate.getTime()-startdate.getTime()+"");
			offer.setType(offer_type_Service.findOne(type));
			offerService.save(offer);
		}
		mav.setViewName("redirect:/admin/view_offers");
		return mav;
	}
}
