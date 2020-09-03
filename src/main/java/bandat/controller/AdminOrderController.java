package bandat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.OrderSneakerDTO;
import bandat.service.impl.CustomerService;
import bandat.service.impl.OrderSneakerService;

@Controller
public class AdminOrderController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderSneakerService orderSneakerService;
	
	@RequestMapping(value = "/admin/order/list",method = RequestMethod.GET)
	public ModelAndView orderList() {
		ModelAndView modelAndView=new ModelAndView("/admin/order/orderlist");
		List<OrderSneakerDTO> orderSneakerDTOs=orderSneakerService.findAllByAtiveAdminStatus();
		modelAndView.addObject("orders", orderSneakerDTOs);
		return modelAndView;
	}
}
