package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.OrderSneakerDTO;
import bandat.entity.OrderSneakerEntity;

@Component
public class OrderSneakerConverter {
	public OrderSneakerDTO convertToDTO(OrderSneakerEntity orderSneakerEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 OrderSneakerDTO orderSneakerDTO=modelMapper.map(orderSneakerEntity, OrderSneakerDTO.class);
		 orderSneakerDTO.setCustomerName(orderSneakerEntity.getCustomerEntity().getFullname());
		 orderSneakerDTO.setCustomerUsername(orderSneakerEntity.getCustomerEntity().getUsername());
		 return orderSneakerDTO;
	}
	public OrderSneakerEntity convertToEntity(OrderSneakerDTO orderSneakerDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 OrderSneakerEntity orderSneakerEntity=modelMapper.map(orderSneakerDTO, OrderSneakerEntity.class);
		 return orderSneakerEntity;
	}
}
