package bandat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bandat.constant.SystemConstant;
import bandat.converter.BrandSneakerConverter;
import bandat.dto.BrandSneakerDTO;
import bandat.entity.BrandSneakerEntity;
import bandat.repository.BrandSneakerRepository;
import bandat.repository.SneakerRepository;
import bandat.service.IBrandSneakerService;

@Component
public class BrandSneakerService implements IBrandSneakerService{
	
	@Autowired
	private BrandSneakerRepository brandSneakerRepository;
	
	@Autowired
	private SneakerRepository sneakerRepository;
	
	@Autowired
	private BrandSneakerConverter brandSneakerConverter;
	
	@Override
	public List<BrandSneakerDTO> findAll() {
		List<BrandSneakerEntity> brandSneakerEntities= brandSneakerRepository.findByStatus(1);
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
		BrandSneakerEntity brandSneaker=brandSneakerRepository.findByNameIgnoreCaseAndStatus(brandSneakerDTO.getName(),SystemConstant.INACTIVE_STATUS);
		if(brandSneaker!=null)
		{
			brandSneaker.setStatus(SystemConstant.ACTIVE_STATUS);
			brandSneakerRepository.save(brandSneaker);
		}else {
			BrandSneakerEntity brandSneakerEntity=brandSneakerConverter.convertToEntity(brandSneakerDTO);
			brandSneakerEntity.setName(brandSneakerDTO.getName().toUpperCase());
			brandSneakerEntity.setStatus(SystemConstant.ACTIVE_STATUS);
			brandSneakerRepository.save(brandSneakerEntity);
		}
		
		
	}

	@Override
	public BrandSneakerDTO findBrandBySneakerId(Long sneakerId) {
		List<BrandSneakerEntity> brandSneakerEntitys=brandSneakerRepository.findBrandBySneakerId(sneakerId);
		BrandSneakerDTO brandSneakerDTO=brandSneakerConverter.convertToDTO(brandSneakerEntitys.get(0));
		return brandSneakerDTO;
	}

	@Override
	public BrandSneakerDTO findByBrandName(String brandName) {
		BrandSneakerEntity brandSneakerEntity=brandSneakerRepository.findByNameIgnoreCaseAndStatus(brandName,SystemConstant.ACTIVE_STATUS);
		if(brandSneakerEntity!=null)
			return brandSneakerConverter.convertToDTO(brandSneakerEntity);
		else
		return null;
	}

	@Override
	public BrandSneakerDTO findById(Long id) {
		return brandSneakerConverter.convertToDTO(brandSneakerRepository.findById(id));
	}

	@Override
	public void updateBrand(BrandSneakerDTO brandSneakerDTO) {
		BrandSneakerEntity brandSneakerEntity=brandSneakerConverter.convertToEntity(brandSneakerDTO);
		brandSneakerEntity.setName(brandSneakerDTO.getName().toUpperCase());
		brandSneakerRepository.save(brandSneakerEntity);
		
	}

	@Override
	public void deleteBrand(BrandSneakerDTO brandSneakerDTO) {
		for(int i=0;i<brandSneakerDTO.getBrandIds().length;i++) {
			BrandSneakerEntity brandSneakerEntity=brandSneakerRepository.findById(brandSneakerDTO.getBrandIds()[i]);
			brandSneakerEntity.setStatus(SystemConstant.INACTIVE_STATUS);
			brandSneakerRepository.save(brandSneakerEntity);
		}
		
	}

}
