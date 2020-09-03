package bandat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.OrderDetailDTO;
import bandat.dto.OrderSneakerDTO;
import bandat.service.impl.OrderDetailService;
@Controller

public class AdminOrderDetailController {
	@Autowired
	OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/admin/orderdetail/list",method = RequestMethod.GET)
	public ModelAndView listDetail(@RequestParam Long orderId) {
		ModelAndView modelAndView=new ModelAndView("admin/order/orderdetaillist");
		List<OrderDetailDTO> orderDetailDTOs=orderDetailService.listOrderDetail(orderId);
		modelAndView.addObject("details", orderDetailDTOs);
		return modelAndView;
	}
}
