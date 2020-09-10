package bandat.api.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.CustomerDTO;
import bandat.service.impl.CustomerService;
import bandat.util.SessionUtil;

@RestController

@RequestMapping(value = "/api/customer/information")
public class CustomerInformationAPI {
	@Autowired
	CustomerService customerService;
	
	@PutMapping
	public @ResponseBody Integer changeInformation(@RequestBody CustomerDTO customerDTO,HttpServletRequest request) {
		CustomerDTO customerCurrent=new CustomerDTO();
		customerCurrent=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		customerService.changeInformation(customerDTO, customerCurrent);
		return 1;
	}
}
