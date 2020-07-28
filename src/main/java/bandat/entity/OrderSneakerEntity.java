package bandat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ordersneaker")
public class OrderSneakerEntity extends BaseEntity{
	
	@Column(name="address")
	private String address;
	
	@Column(name="totalprice")
	private Long totalPrice;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="amount")
	private Long amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerid")
	private CustomerEntity customerEntity;
	
	@OneToMany(mappedBy = "orderEntity")
	private List<OrderDetailEntity> orderDetailEntities=new ArrayList<OrderDetailEntity>();

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<OrderDetailEntity> getOrderDetailEntities() {
		return orderDetailEntities;
	}

	public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
		this.orderDetailEntities = orderDetailEntities;
	}
	
	
	
}
