package bandat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.OrderDetailEntity;
import bandat.entity.OrderSneakerEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
	List<OrderDetailEntity> findByOrderEntity(OrderSneakerEntity orderSneakerEntity );
}
