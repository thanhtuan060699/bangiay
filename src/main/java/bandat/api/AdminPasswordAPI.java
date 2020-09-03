package bandat.api;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.MyUser;
import bandat.dto.UserDTO;
import bandat.service.impl.UserService;
import bandat.util.ConvertMD5ToStringUtils;
import bandat.util.PasswordMD5Utils;
import bandat.util.SecurityUtils;

@RestController
public class AdminPasswordAPI {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api/user/changepassword",method = RequestMethod.POST)
	public @ResponseBody Integer changePasswordAPI(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {
		try {
			if(userDTO.getPassword().equals(userDTO.getConfirmPassword())==false) {
				return 1;
			}
			MyUser myUser=SecurityUtils.getPrincipal();
			UserDTO oldUserDTO=userService.findByUserNameAndStatus(myUser.getUsername(), 1);
			boolean matched = BCrypt.checkpw(userDTO.getOldPassword(),oldUserDTO.getPassword());
			if(matched==false) {
				return 2;
			}
			 String newPassword = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
			 oldUserDTO.setPassword(newPassword);
			 userService.changePassword(oldUserDTO, newPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 3;
	}
}
