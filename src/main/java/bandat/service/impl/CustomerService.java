package bandat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.CustomerConverter;
import bandat.dto.CustomerDTO;
import bandat.entity.CustomerEntity;
import bandat.repository.CustomerRepository;
import bandat.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@Override
	public void addRegister(CustomerDTO customerDTO) {
		CustomerEntity customerEntity=customerConverter.convertToEntity(customerDTO);
		customerRepository.save(customerEntity);
		
		
	}

	@Override
	public CustomerDTO findByUsernameAndStatus(String username, Integer status) {
		CustomerEntity customerEntity=customerRepository.findByUsernameAndStatus(username, status);
		if(customerEntity==null) {
			return null;
		}
		return customerConverter.convertToDTO(customerEntity);
		
	}

	@Override
	public CustomerDTO findByEmail(String email) {
		CustomerEntity customerEntity=customerRepository.findByEmail(email);
		if(customerEntity==null)
			return null;
		return customerConverter.convertToDTO(customerEntity);
	}

	@Override
	public void changePassword(CustomerDTO customerDTO) {
		customerRepository.save(customerConverter.convertToEntity(customerDTO));
		
	}

	@Override
	public void changeInformation(CustomerDTO customerDTO, CustomerDTO customerCurrent) {
		customerDTO.setId(customerCurrent.getId());
		customerDTO.setPassword(customerCurrent.getPassword());
		customerDTO.setUsername(customerCurrent.getUsername());
		customerDTO.setStatus(1);
		CustomerEntity customerEntity=customerConverter.convertToEntity(customerDTO);
		customerRepository.save(customerEntity);
	}

	@Override
	public CustomerDTO findById(CustomerDTO customerDTO) {
		CustomerEntity customerEntity=customerRepository.findOne(customerDTO.getId());
		return customerConverter.convertToDTO(customerEntity);
	}
	
}
