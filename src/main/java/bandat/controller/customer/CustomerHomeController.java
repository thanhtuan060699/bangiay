package bandat.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.service.IBrandSneakerService;
import bandat.util.SessionUtil;

@Controller
public class CustomerHomeController {
	@Autowired 
	IBrandSneakerService brandSneakerService;
	
	@RequestMapping(value = "/allstore/trangchu",method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/homecustomer");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
	}
}
