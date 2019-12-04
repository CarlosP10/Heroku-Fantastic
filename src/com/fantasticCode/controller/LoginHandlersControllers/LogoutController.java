package com.fantasticCode.controller.LoginHandlersControllers;

//Imports request y response.
import javax.servlet.http.HttpServletRequest;
//Import para el manejor de sesiones.
import javax.servlet.http.HttpSession;

//Import para hacer conexion con los services.
import org.springframework.beans.factory.annotation.Autowired;
//Import para manejo de @Controller.
import org.springframework.stereotype.Controller;
//Import para manejo de RequestMapping (paginas .jsp).
import org.springframework.web.bind.annotation.RequestMapping;
//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

//Import de entidad Account.
import com.fantasticCode.entities.Account;
//Import de servicio AccountService.
import com.fantasticCode.service.AccountService;

//Controlador para manipulacion de ModelandViews.
@Controller
public class LogoutController {
	// Servicio que posee metodos de jpaRepository de AccountService.
	@Autowired
	private AccountService accountServ;

	// Metodo que se encarga de cerrar la sesion e invalidar y destruir los
	// atributos de la sesion, asi tambien actualiza valores de la cuenta.
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request) {
		int account_id = (Integer) session.getAttribute("account_id");
		if (accountServ.findOne(account_id) != null) {
			Account account = accountServ.findOne(account_id);
			account.setOnlinestatus(0);
			accountServ.save(account);
			session.invalidate();
		}
		return new ModelAndView("redirect:/");
	}

}
