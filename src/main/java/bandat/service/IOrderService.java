package bandat.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bandat.dto.CartDTO;
import bandat.dto.CustomerDTO;
import bandat.dto.OrderSneakerDTO;

public interface IOrderService {
	public void addOrderSneaker(CustomerDTO customerDTO,List<CartDTO> cartDTOs,HttpServletRequest request);
	public void deleteAdminOrder(OrderSneakerDTO orderSneakerDTO);
	
}
