package bandat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.service.impl.SneakerService;

@Controller
public class SneakerController {
	
	@Autowired
	SneakerService sneakerService;
	
	@RequestMapping(value="/admin/sneaker/list",method = RequestMethod.GET)
	public ModelAndView listSneaker(@RequestParam("id") String brandSneakerId) {
		ModelAndView modelAndView=new ModelAndView("admin/sneaker/list");
		modelAndView.addObject("id", brandSneakerId);
		modelAndView.addObject("sneakers", sneakerService.listSneakerByBrand(Long.parseLong(brandSneakerId)));
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/sneaker/edit",method = RequestMethod.GET)
	public ModelAndView addSneaker() {
		ModelAndView modelAndView=new ModelAndView("admin/sneaker/edit");
		return modelAndView;
	}
}
