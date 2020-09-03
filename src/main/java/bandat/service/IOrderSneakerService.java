package bandat.service;

import java.util.List;

import bandat.dto.CustomerDTO;
import bandat.dto.OrderSneakerDTO;

public interface IOrderSneakerService {
	public List<OrderSneakerDTO> findByCustomer(CustomerDTO customerDTO);
	public List<OrderSneakerDTO> findAllByAtiveAdminStatus();
}
