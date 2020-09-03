package bandat.api.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.CustomerDTO;
import bandat.service.impl.CustomerService;
import bandat.util.SessionUtil;

@RestController

@RequestMapping(value = "/api/customer/login")
public class CustomerLoginAPI {
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public @ResponseBody Integer customerLogin(@RequestBody CustomerDTO customerDTO,HttpServletRequest request) {
		CustomerDTO customer=customerService.findByUsernameAndStatus(customerDTO.getUsername(), 1);
		if(customer==null)
			return 1;
		boolean matched = BCrypt.checkpw(customerDTO.getPassword(), customer.getPassword());
		if(matched==true) {
			SessionUtil.getInstance().putValue(request, "customerSession", customer);
			return 2;
		}
		return 3;
		
	}
}
