package bandat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sizesneaker")
public class SizeOfSneakersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="size")
	private Double size;
	
	@Column(name="amount")
	private Integer amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sneakerid")
	private SneakerEntity sneakerEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public SneakerEntity getSneakerEntity() {
		return sneakerEntity;
	}

	public void setSneakerEntity(SneakerEntity sneakerEntity) {
		this.sneakerEntity = sneakerEntity;
	}
	
	
	
	
}
