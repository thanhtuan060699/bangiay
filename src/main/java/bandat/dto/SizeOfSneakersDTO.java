package bandat.dto;

public class SizeOfSneakersDTO {
	private Long id;
	
	private Double size;
	
	private Integer amount;
	
	private Long sneakerId;

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

	public Long getSneakerId() {
		return sneakerId;
	}

	public void setSneakerId(Long sneakerId) {
		this.sneakerId = sneakerId;
	}
	
	
	
}
