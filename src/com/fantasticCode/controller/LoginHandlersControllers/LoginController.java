package com.fantasticCode.controller.LoginHandlersControllers;

//Imports request y response.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para uso de metodos GET POST.
import org.springframework.web.bind.annotation.RequestMethod;
//Import para obtener parametros desde .jsp.
import org.springframework.web.bind.annotation.RequestParam;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;
//Import para realizar redirect a un metodo y no una pagina, poseera los atributos previos.
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Import de entidad Account.
import com.fantasticCode.entities.Account;
//Import de servicio AccountService.
import com.fantasticCode.service.AccountService;

import UtilityMethods.SessionMethods;

//Controlador para manipulacion de ModelandViews.
@Controller
public class LoginController extends SessionMethods {
	// Servicio que posee metodos de jpaRepository de AccountService.
	@Autowired
	private AccountService accountServ;

	// Metodo que realiza logica de login donde se asignan tiempos de sesion,
	// atributos de sesion.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		Account account = null;
		// Se verifica que existe una cuenta con los parametros recibidos de la vista,
		// de existir se actualizan los valores de la cuenta y se crea una sesion de
		// este y se redirecciona como rol administrador o cliente.
		if (accountServ.findOneUser(username, password)) {
			account = accountServ.findOneUserByUsernamePassword(username, password);
			
			if (account != null) {
				if(account.getActivestate()!=0) {
				account.setOnlinestatus(1);
				accountServ.save(account);
				sessionCreate(request, account);
				if (account.getRole().getIdrole() == 1) {
					mav.setViewName("redirect:/admin/view_offers");
				} else {
					mav.setViewName("redirect:/show_offers");
				}
				}else {
					mav.setViewName("redirect:/");
				}
			} else {
				redirectAttributes.addFlashAttribute("error", 0);
				mav.setViewName("redirect:/");
			}
			
		} else {
			redirectAttributes.addFlashAttribute("error", 0);

			mav.setViewName("redirect:/");
		}

		return mav;
	}

}
