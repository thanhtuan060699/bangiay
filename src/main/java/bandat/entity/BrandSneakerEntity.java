package bandat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brandsneaker")
public class BrandSneakerEntity extends BaseEntity{
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private Integer status;

	@OneToMany(mappedBy = "brandSneakerEntity")
	private List<SneakerEntity> sneakerEntities=new ArrayList<SneakerEntity>();
	
	

	public List<SneakerEntity> getSneakerEntities() {
		return sneakerEntities;
	}

	public void setSneakerEntities(List<SneakerEntity> sneakerEntities) {
		this.sneakerEntities = sneakerEntities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
