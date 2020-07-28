package bandat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.BrandSneakerDTO;
import bandat.service.IBrandSneakerService;

@Controller
public class BrandSneakerController {
	@Autowired 
	IBrandSneakerService brandSneakerService;
	
	
	@RequestMapping(value = "/admin/brandsneaker/list",method = RequestMethod.GET)
	public ModelAndView listBrandSneaker() {
		ModelAndView modelAndView=new ModelAndView("admin/brandsneaker/list");
		List<BrandSneakerDTO> brandSneakerDTOs=brandSneakerService.findAll();
		modelAndView.addObject("listBrand", brandSneakerDTOs);
		return modelAndView;
	}
}
