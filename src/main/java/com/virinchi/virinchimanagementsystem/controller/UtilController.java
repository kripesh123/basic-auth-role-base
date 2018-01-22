package com.virinchi.virinchimanagementsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilController {
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }else if(request.isUserInRole("ROLE_USER")){
        	return "redirect:/user/home";
        }else if(request.isUserInRole("ROLE_TEACHER")){
        	return "redirect:/teacher/home";
        }else if(request.isUserInRole("ROLE_COORDINATOR")){
        	return "redirect:/coordinator/home";
        }else if(request.isUserInRole("ROLE_ACCOUNTANT")){
        	return "redirect:/accountant/home";
        }else if(request.isUserInRole("ROLE_RECEPTIONIST")){
        	return "redirect:/receptionist/home";
        }
        return "redirect:/access-denied";
    }
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public ModelAndView error(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
