package bandat.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandat.converter.SizeOfSneakersConverter;
import bandat.dto.SizeOfSneakersDTO;
import bandat.entity.SizeOfSneakersEntity;
import bandat.entity.SneakerEntity;
import bandat.repository.SizeOfSneakersRepository;
import bandat.repository.SneakerRepository;
import bandat.service.ISizeOfSneakersService;

@Service
public class SizeOfSneakersService implements ISizeOfSneakersService {
	@Autowired
	SizeOfSneakersConverter sizeOfSneakersConverter;
	
	@Autowired
	SizeOfSneakersRepository sizeOfSneakersRepository;
	
	@Autowired
	SneakerRepository sneakerRepository;
	
	@Override
	public void addSize(SizeOfSneakersDTO sizeOfSneakersDTO) {
		SizeOfSneakersEntity sizeOfSneakersEntity=sizeOfSneakersConverter.convertToEntity(sizeOfSneakersDTO);
		SneakerEntity sneakerEntity=sneakerRepository.findOne(sizeOfSneakersDTO.getSneakerId());
		sizeOfSneakersEntity.setSneakerEntity(sneakerEntity);
		sizeOfSneakersRepository.save(sizeOfSneakersEntity);
		
	}

	@Override
	public List<SizeOfSneakersDTO> findAllBySneakerId(Long sneakerId) {
		List<SizeOfSneakersEntity> sizeOfSneakersEntities=sizeOfSneakersRepository.findAllBySneakerId(sneakerId);
		return  sizeOfSneakersEntities.stream().map(item -> sizeOfSneakersConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public SizeOfSneakersEntity findBySizeAndSneakerId(Double size, Long sneakerId) {
		SneakerEntity sneakerEntity=sneakerRepository.findOne(sneakerId);
		SizeOfSneakersEntity sizeOfSneakersEntity=sizeOfSneakersRepository.findBySizeAndSneakerEntity(size, sneakerEntity);
		if(sizeOfSneakersEntity==null)
			return null;
		else
			return sizeOfSneakersEntity;
	}

	@Override
	public void delete(Long[] sizeIds) {
		for(Long id:sizeIds) {
			sizeOfSneakersRepository.delete(id);
		}
		
	}

	@Override
	public SizeOfSneakersDTO findBySizId(Long id) {
		SizeOfSneakersEntity sizeOfSneakersEntity=sizeOfSneakersRepository.findById(id);
		return sizeOfSneakersConverter.convertToDTO(sizeOfSneakersEntity);
	}

}
