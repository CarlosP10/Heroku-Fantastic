package UtilityMethods;

//Imports request y response.
import javax.servlet.http.HttpServletRequest;
//Import para el manejor de sesiones.
import javax.servlet.http.HttpSession;

//Import para el uso de objeto donde se muestra la vista o .jsp.
import org.springframework.web.servlet.ModelAndView;

//Import de entidad Account.
import com.fantasticCode.entities.Account;

public class SessionMethods extends DateFormatMethods {
	// Metodo que crea una sesion y asigna atributos de una cuenta
	protected HttpSession sessionCreate(HttpServletRequest request, Account account) {
		HttpSession session = request.getSession();
		session.setAttribute("user", account.getUsername());
		session.setAttribute("account_id", account.getIdaccount());
		session.setAttribute("role", account.getRole().getIdrole());
		// Se establece el tiempo de sesion.
		session.setMaxInactiveInterval(30 * 60);
		return session;
	}

	// Metodo que permite redireccionar paginas segun rol
	protected ModelAndView sessionverification(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// Verifica la existencia de un usuario en sesion y redirecciona a metodos de
		// accion.
		if (session.getAttribute("user") != null && session.getAttribute("role") != null
				&& session.getAttribute("account_id") != null) {
			if ((Integer) session.getAttribute("role") == 1) {
				mav.setViewName("redirect:/admin/view_offers");
			} else {
				mav.setViewName("redirect:/show_offers");
			}
		} else {
			mav.setViewName("user/login");

		}
		return mav;
	}

	// Metodo que redirecciona la session en caso de no obtener los atributos.
	protected ModelAndView redirectSession(HttpSession session) {
		if (session.getAttribute("user") == null || session.getAttribute("role") == null
				|| session.getAttribute("account_id") == null || ((Integer) session.getAttribute("role")) != 2) {
			return new ModelAndView("redirect:/");
		}
		return null;
	}
}
