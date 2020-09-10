package bandat.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.CartDTO;
import bandat.service.IBrandSneakerService;
import bandat.util.SessionUtil;

@Controller
public class CartController {
	@Autowired 
	IBrandSneakerService brandSneakerService;
	
	@RequestMapping(value = "/allstore/cart",method = RequestMethod.GET)
	public ModelAndView cartCustomer(HttpServletRequest request,@RequestParam(required = false) Long sneakerId ) {
		ModelAndView modelAndView=new ModelAndView("web/cart");
		List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
		modelAndView.addObject("carts", cartDTOs);
		modelAndView.addObject("brands", brandSneakerService.findAllNotTotal());
		modelAndView.addObject("amountOfCart",SessionUtil.getInstance().getValue(request, "amounts"));
		if(sneakerId!=null) {
			modelAndView.addObject("repeatId",sneakerId);
		}
		if(cartDTOs!=null) {
			modelAndView.addObject("totalPrice", totalPrice(cartDTOs));
		}
		
		return modelAndView;
	}
	public Long totalPrice(List<CartDTO> cartDTOs) {
		long price =0;
		for(CartDTO cartDTO:cartDTOs) {
			price=price+cartDTO.getAmount()*cartDTO.getPrice();
			
		}
		return price;
	}
	
	@RequestMapping(value = "/allstore/cart",method = RequestMethod.POST)
	public @ResponseBody Integer getCart(@RequestBody CartDTO cartDTO,HttpServletRequest request) {
		cartDTO.setTotalOfEachSneaker(cartDTO.getPrice()*cartDTO.getAmount());
		if(cartDTO.getSize()==null) {
			return 2;
		}
 		if(SessionUtil.getInstance().getValue(request, "carts")==null) {
			List<CartDTO> cartDTOs=new ArrayList<CartDTO>();
			cartDTOs.add(cartDTO);
			cartDTO.setIdCard(1);
			SessionUtil.getInstance().putValue(request, "carts", cartDTOs);
			SessionUtil.getInstance().putValue(request, "amounts", getAmountsOfSneakers(cartDTOs));
			return 1;
		}
 		else {
 			List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
 			for(CartDTO cartDTO2:cartDTOs) {
 				if(cartDTO2.getSneakerId()==cartDTO.getSneakerId()) {
 					return 3;
 				}
 			}
 			Integer id=cartDTOs.get(cartDTOs.size()-1).getIdCard()+1;
 			cartDTO.setIdCard(id);
 			cartDTOs.add(cartDTO);
 			SessionUtil.getInstance().putValue(request, "amounts", getAmountsOfSneakers(cartDTOs));
 			SessionUtil.getInstance().putValue(request, "carts", cartDTOs);
 		}
 		
		return 1;
	}
	
	
	public Integer getAmountsOfSneakers(List<CartDTO> cartDTOs) {
		Integer total=0;
		for(CartDTO cartDTO:cartDTOs) {
			total=total+cartDTO.getAmount();
		}
		return total;
	}
}
