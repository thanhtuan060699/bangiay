package bandat.dto;

public class BrandSneakerDTO extends AbstractDTO<BrandSneakerDTO> {
	
	private String name;
	
	private Integer totalOfSneakers;
	
	private Long[] brandIds;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalOfSneakers() {
		return totalOfSneakers;
	}

	public void setTotalOfSneakers(Integer totalOfSneakers) {
		this.totalOfSneakers = totalOfSneakers;
	}

	public Long[] getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(Long[] brandIds) {
		this.brandIds = brandIds;
	}
	
}
