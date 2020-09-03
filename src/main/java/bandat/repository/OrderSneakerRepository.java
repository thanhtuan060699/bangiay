package bandat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.CustomerEntity;
import bandat.entity.OrderSneakerEntity;
import bandat.repository.custom.OrderSneakerRepositoryCustom;

public interface OrderSneakerRepository extends JpaRepository<OrderSneakerEntity, Long>,OrderSneakerRepositoryCustom {
	List<OrderSneakerEntity> findByCustomerEntity(CustomerEntity customerEntity);
	OrderSneakerEntity findById(Long id);
	List<OrderSneakerEntity> findAllByAdminStatus(Integer adminStatus);
}
