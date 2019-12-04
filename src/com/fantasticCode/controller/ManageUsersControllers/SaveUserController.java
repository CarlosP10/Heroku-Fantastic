package com.fantasticCode.controller.ManageUsersControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fantasticCode.entities.Account;
import com.fantasticCode.entities.User;
import com.fantasticCode.service.AccountService;
import com.fantasticCode.service.RoleService;
import com.fantasticCode.service.UserService;


@Controller
public class SaveUserController {
	

	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;

	@Autowired
	RoleService roleService;

	@RequestMapping("client/store")
	public ModelAndView storeclient(@RequestParam("uname") String uname, @RequestParam("ulastname") String ulastname,
			@RequestParam("ucountry") String ucountry, @RequestParam("umunicipality") String umunicipality,
			@RequestParam("uaddress") String uaddress, @RequestParam("ubirthdate") String ubirthdate,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		Account account = new Account();
		User user = new User();
		if(!accountService.findOneUsername(username)) {
			user.setName(uname);
			user.setUlastname(ulastname);
			user.setCountry(ucountry);
			user.setAddress(uaddress);
			user.setUbirthdate(ubirthdate);
			user.setMunicipality(umunicipality);
			User userSaved = userService.savedUser(user);
			account.setUsername(username);
			account.setPassword(password);
			account.setActivestate(0);
			account.setOnlinestatus(0);
			account.setComment("");
			account.setRole(roleService.findOne(2));
			account.setUser(userSaved);
			accountService.save(account);
			mav.setViewName("redirect:/");
		}else {
			mav.setViewName("redirect:/register");
		}
		
		return mav;

	}
}