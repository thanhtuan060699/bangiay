package bandat.service;

import java.util.List;

import bandat.dto.SizeOfSneakersDTO;
import bandat.entity.SizeOfSneakersEntity;

public interface ISizeOfSneakersService {
	public void addSize(SizeOfSneakersDTO sizeOfSneakersDTO);
	public List<SizeOfSneakersDTO> findAllBySneakerId(Long sneakerId);
	public SizeOfSneakersEntity findBySizeAndSneakerId(Double size,Long sneakerId);
	public void delete(Long sizeIds[]);
}
