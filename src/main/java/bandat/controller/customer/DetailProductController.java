package bandat.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.SneakerDTO;
import bandat.service.impl.BrandSneakerService;
import bandat.service.impl.SizeOfSneakersService;
import bandat.service.impl.SneakerService;
import bandat.util.SessionUtil;

@Controller
public class DetailProductController {
	@Autowired
	SneakerService sneakerService;
	
	@Autowired
	BrandSneakerService brandSneakerService;
	
	@Autowired
	SizeOfSneakersService sizeOfSneakersService;
	
	@RequestMapping(value = "/allstore/detailproduct")
	ModelAndView sneakerDetail(@RequestParam(name="id") Long sneakerId,HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("web/detailproduct");
		SneakerDTO sneakerDTO=sneakerService.findById(sneakerId);
		modelAndView.addObject("sneaker", sneakerDTO);
		modelAndView.addObject("brand", brandSneakerService.findBrandBySneakerId(sneakerId));
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("sizes", sizeOfSneakersService.findAllBySneakerId(sneakerId));
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		return modelAndView;
	}
}
