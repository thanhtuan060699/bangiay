package bandat.service;

import java.util.List;

import bandat.dto.BrandSneakerDTO;

public interface IBrandSneakerService {
	public List<BrandSneakerDTO> findAll();
	public List<BrandSneakerDTO> findAllNotTotal();
	public void addBrand(BrandSneakerDTO brandSneakerDTO);
	public BrandSneakerDTO findBrandBySneakerId(Long sneakerId);
	public BrandSneakerDTO findByBrandName(String brandName);
	public BrandSneakerDTO findById(Long id);
	public void updateBrand(BrandSneakerDTO brandSneakerDTO);
	public void deleteBrand(BrandSneakerDTO brandSneakerDTO);
}
