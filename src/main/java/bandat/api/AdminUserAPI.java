package bandat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.UserDTO;
import bandat.service.impl.UserService;


@RestController

@RequestMapping(value = "/api/admin/user")
public class AdminUserAPI {
	@Autowired
	UserService userService;
	@PostMapping
	public @ResponseBody Integer addUser(@RequestBody UserDTO userDTO) {
		Boolean sameUser=userService.sameUserName(userDTO);
		if(sameUser==true)
			return 1;
		if(userDTO.getPassword().equals(userDTO.getConfirmPassword())==false) {
			return 3;
		}
		else {
			userService.addUser(userDTO);
		}
		return 2;
	}
}
