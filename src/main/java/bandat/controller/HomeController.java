package bandat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value="/admin/home",method = RequestMethod.GET )
	public ModelAndView homePage() {
		ModelAndView modelAndView=new ModelAndView("admin/home");
		return modelAndView;
	} 
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView=new ModelAndView("login");
		return modelAndView;
	}
	
	
		
	
}
