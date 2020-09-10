package bandat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.SizeOfSneakersDTO;
import bandat.service.impl.SizeOfSneakersService;

@Controller
public class SizeController {
	@Autowired
	SizeOfSneakersService sizeOfSneakersService;
	
	@RequestMapping(value="/admin/sneaker/size/list",method = RequestMethod.GET)
	public ModelAndView listSize(@RequestParam("id") Long sneakerId) {
		ModelAndView modelAndView=new ModelAndView("admin/size/sizelist");
		List<SizeOfSneakersDTO>  dtos=sizeOfSneakersService.findAllBySneakerId(sneakerId);
		modelAndView.addObject("sizes",dtos );
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/sneaker/size/update",method = RequestMethod.GET)
	public ModelAndView updateSize(@RequestParam("id") Long id) {
		ModelAndView modelAndView=new ModelAndView("admin/size/sizeupdate");
		modelAndView.addObject("sizeUpdate", sizeOfSneakersService.findBySizId(id));
		return modelAndView;
	}
}
