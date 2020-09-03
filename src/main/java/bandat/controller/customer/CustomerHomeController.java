package bandat.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.CustomerDTO;
import bandat.service.IBrandSneakerService;
import bandat.util.SessionUtil;

@Controller
public class CustomerHomeController {
	@Autowired 
	IBrandSneakerService brandSneakerService;
	
	@RequestMapping(value = "/allstore/trangchu",method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/homecustomer");
		CustomerDTO customerDTO=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		if(customerDTO!=null) {
			modelAndView.addObject("customerSession", customerDTO);
		}
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
	}
	@RequestMapping(value = "/allstore/register",method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/register");
		
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
	}
	@RequestMapping(value = "/allstore/customer/login",method = RequestMethod.GET)
	public ModelAndView customerLogin(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/customerlogin");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
	}
	@RequestMapping(value = "/allstore/customer/logout",method = RequestMethod.GET)
	public ModelAndView customerLogout(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/homecustomer");
		SessionUtil.getInstance().removeValue(request, "customerSession");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;	
		}
}
