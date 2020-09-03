package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.CustomerEntity;
import bandat.repository.custom.CustomerRepositoryCustom;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>,CustomerRepositoryCustom{
	public CustomerEntity findByUsernameAndStatus(String username,Integer status);
	public CustomerEntity findByEmail(String email);
}
