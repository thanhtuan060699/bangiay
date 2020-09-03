package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.SneakerConverter;
import bandat.dto.SneakerDTO;
import bandat.entity.BrandSneakerEntity;
import bandat.entity.SneakerEntity;
import bandat.repository.BrandSneakerRepository;
import bandat.repository.SizeOfSneakersRepository;
import bandat.repository.SneakerRepository;
import bandat.service.ISneakerService;

@Service
public class SneakerService implements ISneakerService {

	@Autowired 
	SneakerRepository sneakerRepository;
	
	@Autowired
	BrandSneakerRepository brandSneakerRepository;
	
	@Autowired
	SizeOfSneakersRepository sizeOfSneakersRepository;
	
	@Autowired
	SneakerConverter sneakerConverter;
	
	@Override
	public void addSneaker(SneakerDTO sneakerDTO) {
		BrandSneakerEntity brandSneakerEntity=brandSneakerRepository.findOne(sneakerDTO.getBrandSneakerId());
		SneakerEntity sneakerEntity=sneakerConverter.convertToEntity(sneakerDTO);
		sneakerEntity.setBrandSneakerEntity(brandSneakerEntity);
		sneakerRepository.save(sneakerEntity);
	}

	@Override
	public List<SneakerDTO> listSneakerByBrand(Long brandSneakerId) {
		List<SneakerEntity> sneakerEntities=sneakerRepository.listSneakerByBrandId(brandSneakerId);
		return  sneakerEntities.stream().map(item -> sneakerConverter.convertToDTO(item)).collect(Collectors.toList());
		
	}

	@Override
	public SneakerDTO findById(Long sneakerId) {
		SneakerEntity sneakerEntity=sneakerRepository.findOne(sneakerId);
		SneakerDTO sneakerDTO=sneakerConverter.convertToDTO(sneakerEntity);
		return sneakerDTO;
	}

	@Override
	public SneakerDTO findByName(String name) {
		SneakerEntity sneakerEntity=sneakerRepository.findByNameIgnoreCase(name);
		if(sneakerEntity==null)
			return null;
		else
			return sneakerConverter.convertToDTO(sneakerEntity);
	}

	@Override
	public void deleteSneaker(SneakerDTO sneakerDTO) {
		for(int i=0;i<sneakerDTO.getSneakerIds().length;i++) {
			SneakerEntity sneakerEntity=sneakerRepository.findOne(sneakerDTO.getSneakerIds()[i]);
			for(int j=0;j<sneakerEntity.getSizeOfSneakerEntities().size();j++) {
				sizeOfSneakersRepository.delete(sneakerEntity.getSizeOfSneakerEntities().get(j).getId());
			}
			sneakerRepository.delete(sneakerEntity.getId());
		}
		
	}

}
