package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.constant.SystemConstant;
import bandat.converter.OrderSneakerConverter;
import bandat.dto.CustomerDTO;
import bandat.dto.OrderSneakerDTO;
import bandat.entity.CustomerEntity;
import bandat.entity.OrderSneakerEntity;
import bandat.repository.CustomerRepository;
import bandat.repository.OrderSneakerRepository;
import bandat.service.IOrderSneakerService;

@Service
public class OrderSneakerService implements IOrderSneakerService {
	@Autowired
	OrderSneakerRepository orderSneakerRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderSneakerConverter orderSneakerConverter;
	
	@Override
	public List<OrderSneakerDTO> findByCustomer(CustomerDTO customerDTO) {
		CustomerEntity customerEntity=customerRepository.findOne(customerDTO.getId());
		List<OrderSneakerEntity> orderSneakerEntities=orderSneakerRepository.findByCustomerEntity(customerEntity);
		return  orderSneakerEntities.stream().map(item -> orderSneakerConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	@Override
	public List<OrderSneakerDTO> findAllByAtiveAdminStatus() {
		List<OrderSneakerEntity> orderSneakerEntities=orderSneakerRepository.findAllByAdminStatus(SystemConstant.ACTIVE_STATUS);
		return orderSneakerEntities.stream().map(item ->orderSneakerConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	
}
