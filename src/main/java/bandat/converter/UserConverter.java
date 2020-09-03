package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.UserDTO;
import bandat.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO convertToDTO(UserEntity userEntity) {
		ModelMapper modelMapper=new ModelMapper();
		UserDTO userDTO=modelMapper.map(userEntity, UserDTO.class);
		userDTO.setRole(userEntity.getRoles().get(0).getName());
		return userDTO;
	}
	public UserEntity convertToEntity(UserDTO userDTO) {
		ModelMapper modelMapper=new ModelMapper();
		UserEntity userEntity=modelMapper.map(userDTO,UserEntity.class);
		return userEntity;
		
	}
}
