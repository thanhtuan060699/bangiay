package bandat.dto;

public class CartDTO {
	private Integer idCard;
	
	private String sneakerName;
	
	private Double size;
	
	private Long price;
	
	private Integer amount;
	
	private String nameImage;
	
	private Long totalOfEachSneaker;
	
	private Long totalCart;
	
	private Integer amountMax;
	
	public String getSneakerName() {
		return sneakerName;
	}

	public void setSneakerName(String sneakerName) {
		this.sneakerName = sneakerName;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
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

	public Long getTotalOfEachSneaker() {
		return totalOfEachSneaker;
	}

	public void setTotalOfEachSneaker(Long totalOfEachSneaker) {
		this.totalOfEachSneaker = totalOfEachSneaker;
	}

	public Long getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(Long totalCart) {
		this.totalCart = totalCart;
	}

	public String getNameImage() {
		return nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}

	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public Integer getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Integer amountMax) {
		this.amountMax = amountMax;
	}
	
	
	
}
