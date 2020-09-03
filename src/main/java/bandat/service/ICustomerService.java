package bandat.service;

import bandat.dto.CustomerDTO;

public interface ICustomerService {
	public void addRegister(CustomerDTO customerDTO);
	public CustomerDTO findByUsernameAndStatus(String username,Integer status);
	public CustomerDTO findByEmail(String email);
	public void changePassword(CustomerDTO customerDTO);
}
