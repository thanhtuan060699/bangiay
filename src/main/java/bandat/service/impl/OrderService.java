package bandat.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.constant.SystemConstant;
import bandat.converter.CustomerConverter;
import bandat.converter.OrderSneakerConverter;
import bandat.dto.CartDTO;
import bandat.dto.CustomerDTO;
import bandat.dto.OrderSneakerDTO;
import bandat.entity.CustomerEntity;
import bandat.entity.OrderDetailEntity;
import bandat.entity.OrderSneakerEntity;
import bandat.entity.SizeOfSneakersEntity;
import bandat.entity.SneakerEntity;
import bandat.repository.CustomerRepository;
import bandat.repository.OrderDetailRepository;
import bandat.repository.OrderSneakerRepository;
import bandat.repository.SizeOfSneakersRepository;
import bandat.repository.SneakerRepository;
import bandat.service.IOrderService;
import bandat.util.SessionUtil;

@Service
public class OrderService implements IOrderService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@Autowired
	OrderSneakerConverter orderSneakerConverter;
	
	@Autowired
	OrderSneakerRepository orderSneakerRepository;
	
	@Autowired
	SneakerRepository sneakerRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	SizeOfSneakersRepository sizeOfSneakersRepository;
	
	@Override
	public void addOrderSneaker(CustomerDTO customerDTO,List<CartDTO> cartDTOs,HttpServletRequest request) {
		
		//Save customer
		CustomerDTO customer=(CustomerDTO) SessionUtil.getInstance().getValue(request, "customerSession");
		CustomerEntity customerEntity;
		if(customer==null) {
			customerEntity=customerConverter.convertToEntity(customerDTO);
			customerEntity=customerRepository.save(customerEntity);
		}else
			customerEntity=customerConverter.convertToEntity(customer);
		
		//Save order
		OrderSneakerEntity orderSneakerEntity=new OrderSneakerEntity();
		orderSneakerEntity.setAmount(amountOfOrder(cartDTOs));
		orderSneakerEntity.setTotalPrice(priceOfOrder(cartDTOs));
		orderSneakerEntity.setCustomerEntity(customerEntity);
		orderSneakerEntity.setProvince(customerDTO.getProvince());
		orderSneakerEntity.setDistrict(customerDTO.getDistrict());
		orderSneakerEntity.setWard(customerDTO.getWard());
		orderSneakerEntity.setEmail(customerDTO.getEmail());
		orderSneakerEntity.setPhonenumber(customerDTO.getPhonenumber());
		orderSneakerEntity.setAddress(customerDTO.getAddress());
		orderSneakerEntity.setCustomerStatus(SystemConstant.ACTIVE_STATUS);
		orderSneakerEntity.setAdminStatus(SystemConstant.ACTIVE_STATUS);
		orderSneakerEntity=orderSneakerRepository.save(orderSneakerEntity);
		
		//Save detail order
		
		for(CartDTO cartDTO:cartDTOs) {
			OrderDetailEntity orderDetailEntity=new OrderDetailEntity();
			orderDetailEntity.setOrderEntity(orderSneakerEntity);
			orderDetailEntity.setAmount(cartDTO.getAmount());
			orderDetailEntity.setPrice(cartDTO.getPrice());
			orderDetailEntity.setSize(cartDTO.getSize());
			orderDetailEntity.setSneakerName(cartDTO.getSneakerName());
			orderDetailRepository.save(orderDetailEntity);
			//Update amount table size
			SneakerEntity sneakerEntity= sneakerRepository.findOne(cartDTO.getSneakerId());
			SizeOfSneakersEntity sizeOfSneakersEntity=
					sizeOfSneakersRepository.findBySizeAndSneakerEntity(cartDTO.getSize(),sneakerEntity);
			sizeOfSneakersEntity.setAmount(cartDTO.getAmountMax()-cartDTO.getAmount());
			sizeOfSneakersRepository.save(sizeOfSneakersEntity);
			
			
		}
		
		
		
	}
	public Integer amountOfOrder(List<CartDTO> cartDTOs) {
		Integer amount=0;
		for(CartDTO cartDTO:cartDTOs) {
			amount=amount+cartDTO.getAmount();
		}
		return amount;
	}
	public Long priceOfOrder(List<CartDTO> cartDTOs) {
		long price=0;
		for(CartDTO cartDTO:cartDTOs) {
			price=price+cartDTO.getTotalOfEachSneaker();
		}
		return price;
	}
	@Override
	public void deleteAdminOrder(OrderSneakerDTO orderSneakerDTO) {
		for(int i=0;i<orderSneakerDTO.getOrderIds().length;i++) {
			OrderSneakerEntity orderSneakerEntity=orderSneakerRepository.findById(orderSneakerDTO.getOrderIds()[i]);
			orderSneakerEntity.setAdminStatus(SystemConstant.INACTIVE_STATUS);
			orderSneakerRepository.save(orderSneakerEntity);
		}
		
	}

	
}
