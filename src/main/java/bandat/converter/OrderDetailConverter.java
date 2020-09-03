package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.OrderDetailDTO;
import bandat.entity.OrderDetailEntity;

@Component
public class OrderDetailConverter {
	public OrderDetailDTO convertToDTO(OrderDetailEntity orderDetailEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 OrderDetailDTO orderDetailDTO=modelMapper.map(orderDetailEntity, OrderDetailDTO.class);
		 return orderDetailDTO;
	}
	public OrderDetailEntity convertToEntity(OrderDetailDTO orderDetailDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 OrderDetailEntity orderDetailEntity=modelMapper.map(orderDetailDTO, OrderDetailEntity.class);
		 return orderDetailEntity;
	}
}
