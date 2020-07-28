package bandat.dto;

public class SneakerDTO {
	private Long id;
	
	private String name;
	
	private Long price;

	private String base64;
	
	private String nameImage;
	
	private Long brandSneakerId;
	
	private String brandName;
	
	
	public String getBase64() {
		return base64.split(",")[1];
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getNameImage() {
		return nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getBrandSneakerId() {
		return brandSneakerId;
	}

	public void setBrandSneakerId(Long brandSneakerId) {
		this.brandSneakerId = brandSneakerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
