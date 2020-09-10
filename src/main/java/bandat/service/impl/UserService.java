package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import bandat.constant.SystemConstant;
import bandat.converter.UserConverter;
import bandat.dto.UserDTO;
import bandat.entity.RoleEntity;
import bandat.entity.UserEntity;
import bandat.entity.UserRoleEntity;
import bandat.repository.RoleRepository;
import bandat.repository.UserRepository;
import bandat.repository.UserRoleRepository;
import bandat.service.IUserService;


@Service

public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
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

	@Override
	public boolean sameUserName(UserDTO userDTO) {
		UserEntity userEntity=userRepository.findOneByUserNameAndStatus(userDTO.getUsername(), SystemConstant.ACTIVE_STATUS);
		if(userEntity!=null)
			return true;
		return false;
	}

	@Override
	public void addUser(UserDTO userDTO) {
		UserEntity userEntity=userConverter.convertToEntity(userDTO);
		String hashedPassword = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
		userEntity.setPassword(hashedPassword);
		userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		userEntity=userRepository.save(userEntity);
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setCode(userDTO.getRole());
		roleEntity.setName(userDTO.getRole());
		roleEntity=roleRepository.save(roleEntity);
		UserRoleEntity userRoleEntity=new UserRoleEntity();
		userRoleEntity.setRoleEntity(roleEntity);
		userRoleEntity.setUserEntity(userEntity);
		userRoleRepository.save(userRoleEntity);
		
	}
	
}
