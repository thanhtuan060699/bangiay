package bandat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bandat.dto.UserDTO;
import bandat.service.impl.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/admin/user/list",method =RequestMethod.GET )
	public ModelAndView listUser() {
		ModelAndView modelAndView=new ModelAndView("admin/user/userlist");
		List<UserDTO> userDTOs=userService.findAll();
		modelAndView.addObject("users", userDTOs);
		return modelAndView;
	}
	
	@RequestMapping(value = "admin/user/password",method = RequestMethod.GET)
	public ModelAndView changePassword() {
		ModelAndView modelAndView=new ModelAndView("admin/user/userpassword");
		return modelAndView;
	}
}
