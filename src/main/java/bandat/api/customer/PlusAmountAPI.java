package bandat.api.customer;

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
	public @ResponseBody CartDTO plusAmountCart(@RequestBody CartDTO cartDTO,HttpServletRequest request) {
		List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
		CartDTO cartChange=findPlus(cartDTOs, cartDTO);
		int amount=cartChange.getAmount();
		if(amount<cartChange.getAmountMax()) {
			cartChange.setAmount(amount+1);
			cartChange.setTotalOfEachSneaker(cartChange.getPrice()*cartChange.getAmount());
			int index=findIndex(cartDTOs, cartChange);
			cartDTOs.set(findIndex(cartDTOs, cartChange), cartChange);
			SessionUtil.getInstance().putValue(request, "carts", cartDTOs);
		}
		return cartChange;
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
