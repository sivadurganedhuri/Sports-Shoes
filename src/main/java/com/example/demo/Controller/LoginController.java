package com.example.demo.Controller;

import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.Login;
import com.example.demo.productRepo.LoginRepo;
import com.example.demo.services.LoginService;

public class LoginController {

	 @Autowired
		LoginRepo repo;
	
	 Logger log = Logger.getAnonymousLogger();

	
		@RequestMapping("/login")
		public ModelAndView login(@RequestParam("username")String username,@RequestParam("password") String password) {
			
			ModelAndView mv= new ModelAndView();
			log.info("tested1");
			log.info("username"+username);
			log.info("password"+password);
			if(repo.getbyusername(username).equals(repo.getbypassword(password))) {
				
				log.info("tested2");
				mv.setViewName("home.jsp");
			}else
			{
				mv.setViewName("welcome.jsp");
			}
			log.info("tested4");
			return mv;
		}
		

	 
}
