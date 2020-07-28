package bandat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetail")
public class OrderDetailEntity extends BaseEntity{
	@Column(name="amount")
	private Integer amount;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name="orderid")
	private OrderSneakerEntity orderEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sneakerid")
	private SneakerEntity sneakerEntity;
	
	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public OrderSneakerEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderSneakerEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public SneakerEntity getSneakerEntity() {
		return sneakerEntity;
	}

	public void setSneakerEntity(SneakerEntity sneakerEntity) {
		this.sneakerEntity = sneakerEntity;
	}
	
	
}
