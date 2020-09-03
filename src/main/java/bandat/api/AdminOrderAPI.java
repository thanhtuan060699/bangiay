package bandat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.OrderSneakerDTO;
import bandat.service.impl.OrderService;

@RestController

@RequestMapping(value = "/api/admin/order")
public class AdminOrderAPI {
	@Autowired
	OrderService orderService;
	
	@DeleteMapping
	public @ResponseBody Integer deleteAdminOrder(@RequestBody OrderSneakerDTO orderSneakerDTO) {
		orderService.deleteAdminOrder(orderSneakerDTO);
		return 1;
	}
}
