package bandat.service;

import java.util.List;

import bandat.dto.SneakerDTO;

public interface ISneakerService {
	public void addSneaker(SneakerDTO sneakerDTO);
	public List<SneakerDTO> listSneakerByBrand(Long brandSneakerId);
	public SneakerDTO findById(Long sneakerId);
	public SneakerDTO findByName(String name);
	public void deleteSneaker(SneakerDTO sneakerDTO);
	
}
