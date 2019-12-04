package com.fantasticCode.controller.ManageAccountsControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.service.AccountService;


@Controller
public class ViewAccountsController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("account/list")
		public ModelAndView vertodos(HttpSession session, 
				HttpServletRequest request, 
				@RequestParam(required = false) Integer page) throws Exception{
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=1){
			return new ModelAndView("redirect:/logout");
		}
			ModelAndView mav = new ModelAndView();
			int pagina=0;
			if(page!=null) {pagina = page;}
			
			List<Account> accounts = null;
			
			accounts = accountService.findAll(pagina);
			System.out.println("El tamañò es:"+accounts.size());
			mav.addObject("accounts", accounts);
			mav.addObject("actual", Math.min((pagina + 1) * 10,accountService.countAll()));
			mav.addObject("total", accountService.countAll());
			mav.addObject("pagina", pagina + 1);
			mav.setViewName("admin/account/view_all");
			return mav;
		}
	
	
	
	
	
}