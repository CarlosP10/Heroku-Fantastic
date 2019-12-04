package com.fantasticCode.controller.ManageAccountsControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.service.AccountService;


@Controller
public class ViewSpecificAccountsController {
	

	@Autowired
	private AccountService accountService;


	
	@RequestMapping(value="account/view/{id}")
	public ModelAndView view(HttpSession session,@PathVariable(value="id") int id ,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=1){
			return new ModelAndView("redirect:/logout");
		}
		ModelAndView mav = new ModelAndView();
		Account account=accountService.findOne(id);
		if(account!=null) {
			mav.addObject("account", account);
			mav.setViewName("admin/account/view");
			}
			else {
				return new ModelAndView("redirect:/account/list");
			}
		return mav;	
	}
	
	
	

	
	
}