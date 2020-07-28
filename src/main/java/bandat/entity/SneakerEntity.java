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
@Table(name="sneaker")
public class SneakerEntity extends BaseEntity{
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Long price;
	
	@Column(name="image")
	private String image;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brandSneakerId")
	private BrandSneakerEntity brandSneakerEntity;
	
	@OneToMany(mappedBy = "sneakerEntity")
	private List<OrderDetailEntity> orderDetailEntities=new ArrayList<OrderDetailEntity>();
	
	@OneToMany(mappedBy = "sneakerEntity")
	private List<SizeOfSneakersEntity> sizeOfSneakerEntities=new ArrayList<SizeOfSneakersEntity>();
	

	public BrandSneakerEntity getBrandSneakerEntity() {
		return brandSneakerEntity;
	}

	public void setBrandSneakerEntity(BrandSneakerEntity brandSneakerEntity) {
		this.brandSneakerEntity = brandSneakerEntity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	


	public List<SizeOfSneakersEntity> getSizeOfSneakerEntities() {
		return sizeOfSneakerEntities;
	}

	public void setSizeOfSneakerEntities(List<SizeOfSneakersEntity> sizeOfSneakerEntities) {
		this.sizeOfSneakerEntities = sizeOfSneakerEntities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrderDetailEntity> getOrderDetailEntities() {
		return orderDetailEntities;
	}

	public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
		this.orderDetailEntities = orderDetailEntities;
	}
	
	
}
