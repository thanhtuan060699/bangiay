package bandat.api.customer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.OrderSneakerDTO;

@RestController

@RequestMapping(value = "/api/customer/order")
public class CustomerOrderAPI {
	@DeleteMapping
	public void deleteCustomerOrder(@RequestBody OrderSneakerDTO orderSneakerDTO) {
		System.out.println("ttt");
	}

}
