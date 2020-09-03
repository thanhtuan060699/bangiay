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
	
	
	@ManyToOne(fetch =FetchType.EAGER )
	@JoinColumn(name="orderid")
	private OrderSneakerEntity orderEntity;
	
	
	@Column(name="size")
	private Double size;
	
	@Column(name="sneakerName")
	private String sneakerName;
	
	@Column(name="price")
	private Long price;

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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getSneakerName() {
		return sneakerName;
	}

	public void setSneakerName(String sneakerName) {
		this.sneakerName = sneakerName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
