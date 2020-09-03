package bandat.dto;

public class OrderDetailDTO {
	private Long id;
	
	private Double size;
	
	private String sneakerName;
	
	private Long price;
	
	private Integer amount;

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
