package bandat.api.customer;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.CartDTO;
import bandat.util.SessionUtil;

@RestController

@RequestMapping(value = "/api/plus/amountcart")
public class PlusAmountAPI {
	@PostMapping
	public @ResponseBody HashMap<String, Object> plusAmountCart(@RequestBody CartDTO cartDTO,HttpServletRequest request) {
		List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		CartDTO cartChange=findPlus(cartDTOs, cartDTO);
		int amount=cartChange.getAmount();
		if(amount<cartChange.getAmountMax()) {
			cartChange.setAmount(amount+1);
			cartChange.setTotalOfEachSneaker(cartChange.getPrice()*cartChange.getAmount());
			int index=findIndex(cartDTOs, cartChange);
			cartDTOs.set(findIndex(cartDTOs, cartChange), cartChange);
			SessionUtil.getInstance().putValue(request, "carts", cartDTOs);
		}
		hashMap.put("cartDTO", cartChange);
		hashMap.put("totalPrice", totalPrice(cartDTOs));
		return hashMap;
	}
	
	public Long totalPrice(List<CartDTO> cartDTOs) {
		long price =0;
		for(CartDTO cartDTO:cartDTOs) {
			price=price+cartDTO.getAmount()*cartDTO.getPrice();
			
		}
		return price;
	}
	
	private CartDTO findPlus(List<CartDTO> cartDTOs,CartDTO cart) {
		for(CartDTO cartDTO:cartDTOs) {
			if(cartDTO.getNameImage().equals(cart.getNameImage())&&cartDTO.getSneakerName().equals(cart.getSneakerName())) {
				return cartDTO;
			}
		}
		return null;
	}
	private Integer findIndex(List<CartDTO> cartDTOs,CartDTO cart) {
		Integer index=0;
		for(CartDTO cartDTO:cartDTOs) {
			if(cartDTO.getNameImage().equals(cart.getNameImage())&&cartDTO.getSneakerName().equals(cart.getSneakerName())) {
				return index;
			}
			else
				index++;
		}
		return index;
	}
}	
