package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.UserConverter;
import bandat.dto.UserDTO;
import bandat.entity.UserEntity;
import bandat.repository.UserRepository;
import bandat.service.IUserService;


@Service

public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntities=userRepository.findAll();
		return  userEntities.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findByUserNameAndStatus(String username, Integer status) {
		UserEntity userEntity=userRepository.findOneByUserNameAndStatus(username, status);
		return userConverter.convertToDTO(userEntity);
	}

	@Override
	public void changePassword(UserDTO userDTO, String newPassword) {
		UserEntity userEntity=userRepository.findOne(userDTO.getId());
		userEntity.setPassword(newPassword);
		userRepository.save(userEntity);
		
	}
	
}
