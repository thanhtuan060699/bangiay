package bandat.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.CartDTO;
import bandat.service.impl.BrandSneakerService;
import bandat.util.SessionUtil;

@Controller
public class OrderController {
	@Autowired
	BrandSneakerService brandSneakerService;
	
	@RequestMapping(value = "/allstore/checkout",method = RequestMethod.GET)
	public ModelAndView orderCustomer(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/order");
		List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("sneakersCart",cartDTOs );
		return modelAndView;
	}
}
