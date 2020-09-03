package bandat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CustomerController {
	@RequestMapping(value = "/admin/customer/list",method = RequestMethod.GET)
	public ModelAndView customerDisplay() {
		ModelAndView modelAndView=new ModelAndView("admin/customer/clist");
		return modelAndView;
	}
}
