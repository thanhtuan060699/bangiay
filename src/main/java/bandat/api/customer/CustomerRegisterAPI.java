package bandat.api.customer;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.CustomerDTO;
import bandat.service.impl.CustomerService;
import bandat.util.PasswordMD5Utils;

@RestController
@RequestMapping(value = "/api/register")
public class CustomerRegisterAPI {
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public @ResponseBody Integer  register(@RequestBody CustomerDTO customerDTO) {
		try {
			if(customerDTO.getPassword().equals(customerDTO.getConfirmPassword())==false)
				return 2;
			if(customerDTO.getPassword()==null||customerDTO.getConfirmPassword()==null||customerDTO.getEmail()==null
				||customerDTO.getUsername()==null||customerDTO.getPassword()==""||customerDTO.getConfirmPassword()==""
				||StringUtils.isNotBlank(customerDTO.getFullname())==false) {
				return 5;
			}
			String passwordBcrypt = BCrypt.hashpw(customerDTO.getPassword(), BCrypt.gensalt(12));
			CustomerDTO customer=customerService.findByUsernameAndStatus(customerDTO.getUsername(), 1);
			if(customer!=null)
				return 3;
			customer=customerService.findByEmail(customerDTO.getEmail());
			if(customer!=null)
				return 4;
			customerDTO.setPassword(passwordBcrypt);
			customerDTO.setStatus(1);
			customerService.addRegister(customerDTO);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
