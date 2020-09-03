package bandat.service;

import java.util.List;

import bandat.dto.UserDTO;

public interface IUserService {
	public List<UserDTO> findAll();
	public UserDTO findByUserNameAndStatus(String username,Integer status);
	public void changePassword(UserDTO userDTO,String newPassword);
}
