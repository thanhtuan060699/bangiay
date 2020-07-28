package bandat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.BrandSneakerConverter;
import bandat.dto.BrandSneakerDTO;
import bandat.entity.BrandSneakerEntity;
import bandat.repository.BrandSneakerRepository;
import bandat.service.IBrandSneakerService;

@Service
public class BrandSneakerService implements IBrandSneakerService{
	
	@Autowired
	private BrandSneakerRepository brandSneakerRepository;
	
	@Autowired
	private BrandSneakerConverter brandSneakerConverter;
	
	@Override
	public List<BrandSneakerDTO> findAll() {
		List<BrandSneakerEntity> brandSneakerEntities= brandSneakerRepository.findAll();
		List<BrandSneakerDTO> brandSneakerDTOs=new ArrayList<BrandSneakerDTO>();
		for(BrandSneakerEntity brandSneakerEntity:brandSneakerEntities) {
			BrandSneakerDTO  brandSneakerDTO=brandSneakerConverter.convertToDTO(brandSneakerEntity);
			brandSneakerDTO.setTotalOfSneakers(brandSneakerRepository.totalOfSneakersEachBrand(brandSneakerDTO.getId()));
			brandSneakerDTOs.add(brandSneakerDTO);
		}
		return  brandSneakerDTOs;

	}

	@Override
	public List<BrandSneakerDTO> findAllNotTotal() {
		List<BrandSneakerEntity>  brandSneakerEntities=brandSneakerRepository.findAll();
		return  brandSneakerEntities.stream().map(item -> brandSneakerConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public void addBrand(BrandSneakerDTO brandSneakerDTO) {
		BrandSneakerEntity brandSneakerEntity=brandSneakerConverter.convertToEntity(brandSneakerDTO);
		brandSneakerRepository.save(brandSneakerEntity);
		
	}

	@Override
	public BrandSneakerDTO findBrandBySneakerId(Long sneakerId) {
		List<BrandSneakerEntity> brandSneakerEntitys=brandSneakerRepository.findBrandBySneakerId(sneakerId);
		BrandSneakerDTO brandSneakerDTO=brandSneakerConverter.convertToDTO(brandSneakerEntitys.get(0));
		return brandSneakerDTO;
	}

	@Override
	public BrandSneakerDTO findByBrandName(String brandName) {
		return brandSneakerConverter.convertToDTO(brandSneakerRepository.findByBrandName(brandName));
	}

}
