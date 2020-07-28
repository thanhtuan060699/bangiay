package bandat.service;

import java.util.List;

import bandat.dto.SizeOfSneakersDTO;

public interface ISizeOfSneakersService {
	public void addSize(SizeOfSneakersDTO sizeOfSneakersDTO);
	public List<SizeOfSneakersDTO> findAllBySneakerId(Long sneakerId);
}
