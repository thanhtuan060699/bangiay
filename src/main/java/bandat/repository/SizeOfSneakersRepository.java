package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.SizeOfSneakersEntity;
import bandat.repository.custom.SizeOfSneakersRepositoryCustom;

public interface SizeOfSneakersRepository extends JpaRepository<SizeOfSneakersEntity, Long>,SizeOfSneakersRepositoryCustom {

}
