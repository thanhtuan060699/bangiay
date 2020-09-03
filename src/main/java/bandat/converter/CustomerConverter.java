package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.CustomerDTO;
import bandat.entity.CustomerEntity;

@Component
public class CustomerConverter {
	public CustomerDTO convertToDTO(CustomerEntity customerEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 CustomerDTO customerDTO=modelMapper.map(customerEntity, CustomerDTO.class);
		 return customerDTO;
	}
	public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 CustomerEntity customerEntity=modelMapper.map(customerDTO, CustomerEntity.class);
		 return customerEntity;
	}
}
