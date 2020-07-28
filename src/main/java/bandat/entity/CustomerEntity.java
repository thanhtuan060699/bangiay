package bandat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="username")
	private String username;

	@Column(name="status")
	private Integer status;

	@OneToMany(mappedBy ="customerEntity" )
	private List<OrderSneakerEntity> orders=new ArrayList<OrderSneakerEntity>();
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderSneakerEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderSneakerEntity> orders) {
		this.orders = orders;
	}
	
	
}