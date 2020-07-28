package bandat.repository.custom;

import java.util.List;

import bandat.entity.BrandSneakerEntity;

public interface BrandSneakerRepositoryCustom {
	public Integer totalOfSneakersEachBrand(Long brandId);
	public List<BrandSneakerEntity> findBrandBySneakerId(Long sneakerId);
	public BrandSneakerEntity findByBrandName(String brandName);
}
