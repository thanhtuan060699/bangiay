package bandat.dto;

public class BrandSneakerDTO extends AbstractDTO<BrandSneakerDTO> {
	
	private String name;
	
	private Integer totalOfSneakers;
	
	

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
	
}
