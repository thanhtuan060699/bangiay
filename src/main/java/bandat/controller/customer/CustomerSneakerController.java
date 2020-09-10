package bandat.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.BrandSneakerDTO;
import bandat.dto.SneakerDTO;
import bandat.service.impl.BrandSneakerService;
import bandat.service.impl.SneakerService;
import bandat.util.SessionUtil;

@Controller
public class CustomerSneakerController {
	@Autowired
	SneakerService sneakerService;
	
	@Autowired
	BrandSneakerService brandSneakerService;
	
	@RequestMapping(value = "/allstore/listsneaker",method = RequestMethod.GET)
	ModelAndView sneakerCustomer(@RequestParam(name = "id") Long brandId,HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/sneakercustomer");
		List<SneakerDTO> sneakerDTOs=sneakerService.listSneakerByBrand(brandId);
		if(sneakerDTOs.size()==0) {
			modelAndView.addObject("listempty", 1);
		}
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("sneakers",sneakerDTOs );
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
		
	}
}
