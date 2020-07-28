package bandat.repository.custom;

import java.util.List;

import bandat.entity.SizeOfSneakersEntity;

public interface SizeOfSneakersRepositoryCustom {
	public List<SizeOfSneakersEntity> findAllBySneakerId(Long sneakerId);
}
