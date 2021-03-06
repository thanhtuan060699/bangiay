package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.SizeOfSneakersEntity;
import bandat.entity.SneakerEntity;
import bandat.repository.custom.SizeOfSneakersRepositoryCustom;

public interface SizeOfSneakersRepository extends JpaRepository<SizeOfSneakersEntity, Long>,SizeOfSneakersRepositoryCustom {
	SizeOfSneakersEntity findBySizeAndSneakerEntity(Double size,SneakerEntity sneakerEntity);
	SizeOfSneakersEntity findById(Long id);
}
