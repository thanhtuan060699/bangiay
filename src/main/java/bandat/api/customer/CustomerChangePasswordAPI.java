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
@RequestMapping(value = "/api/profile/changepassword")
public class CustomerChangePasswordAPI {
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public @ResponseBody Integer changePassword(@RequestBody CustomerDTO customerDTO,HttpServletRequest request) {
		if(customerDTO.getConfirmPassword()==""||customerDTO.getPassword()==""||customerDTO.getOldPassword()=="")
			return 2;
		if(customerDTO.getPassword().equals(customerDTO.getConfirmPassword())==false) {
			return 1;
		}
		CustomerDTO customer=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		boolean match=BCrypt.checkpw(customerDTO.getOldPassword(), customer.getPassword());
		if(match==false)
			return 3;
		customer.setPassword(BCrypt.hashpw(customerDTO.getPassword(), BCrypt.gensalt(12)));
		customerService.changePassword(customer);
			return 4;
		
	}
	
}
