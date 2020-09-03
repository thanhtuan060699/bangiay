package bandat.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.CustomerDTO;
import bandat.service.impl.BrandSneakerService;
import bandat.service.impl.CustomerService;
import bandat.service.impl.OrderDetailService;
import bandat.service.impl.OrderSneakerService;
import bandat.util.SessionUtil;

@Controller
public class CustomerProfileController {

	@Autowired
	BrandSneakerService brandSneakerService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderSneakerService orderSneakerService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/allstore/profile",method = RequestMethod.GET)
	public ModelAndView customerProfile(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/profile");
		CustomerDTO customerDTO=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("orders",orderSneakerService.findByCustomer(customerDTO));
		return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/allstore/profile/detailorder",method = RequestMethod.GET)
	public ModelAndView customerDetailOrder(HttpServletRequest request,@RequestParam Long orderId) {
		ModelAndView modelAndView=new ModelAndView("web/customerdetailorder");
		modelAndView.addObject("detail", orderDetailService.listOrderDetail(orderId));
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		return modelAndView;
	}
	
	@RequestMapping(value = "/allstore/profile/info",method = RequestMethod.GET)
	public ModelAndView customerInfomation(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/customerinfo");
		CustomerDTO customerDTO=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("customerInfo", customerDTO);
		return modelAndView;
	}
	
	@RequestMapping(value = "/allstore/profile/changepassword",method = RequestMethod.GET)
	public ModelAndView changePassword() {
		ModelAndView modelAndView=new ModelAndView("web/changepassword");
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		return modelAndView;
	}
}
