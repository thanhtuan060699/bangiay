package bandat.service;

import java.util.List;

import bandat.dto.SneakerDTO;
import bandat.entity.SneakerEntity;

public interface ISneakerService {
	public void addSneaker(SneakerDTO sneakerDTO);
	public List<SneakerDTO> listSneakerByBrand(Long brandSneakerId);
	public SneakerDTO findById(Long sneakerId);
}
