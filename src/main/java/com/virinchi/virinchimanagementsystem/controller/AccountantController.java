package com.virinchi.virinchimanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virinchi.virinchimanagementsystem.model.User;
import com.virinchi.virinchimanagementsystem.service.UserService;

@Controller
@RequestMapping(value="/accountant")
public class AccountantController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("accountantMessage","Content Available Only for Users with Accountant Role");
		modelAndView.setViewName("accountant/home");
		return modelAndView;
	}
}
