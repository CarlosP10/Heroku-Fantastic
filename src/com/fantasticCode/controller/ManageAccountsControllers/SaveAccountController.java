package com.fantasticCode.controller.ManageAccountsControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.service.AccountService;


@Controller
public class SaveAccountController {

	@Autowired
	private AccountService accountService;
	

	
	@RequestMapping(value="account/store",method=RequestMethod.POST)
	public ModelAndView store(HttpSession session,@ModelAttribute(name="account") Account account ,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=1){
			return new ModelAndView("redirect:/logout");
		}
		accountService.save(account);
		return new ModelAndView("redirect:/account/list");	
	}
	

	
	
	
}