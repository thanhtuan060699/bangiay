package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.OrderDetailConverter;
import bandat.dto.OrderDetailDTO;
import bandat.entity.OrderDetailEntity;
import bandat.entity.OrderSneakerEntity;
import bandat.repository.OrderDetailRepository;
import bandat.repository.OrderSneakerRepository;
import bandat.service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	OrderSneakerRepository orderSneakerRepository;
	
	@Autowired
	OrderDetailConverter orderDetailConverter;

	@Override
	public List<OrderDetailDTO> listOrderDetail(Long orderId) {
		OrderSneakerEntity orderSneakerEntity=orderSneakerRepository.findOne(orderId);
		List<OrderDetailEntity> orderDetailEntities=orderDetailRepository.findByOrderEntity(orderSneakerEntity);
		return  orderDetailEntities.stream().map(item -> orderDetailConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
