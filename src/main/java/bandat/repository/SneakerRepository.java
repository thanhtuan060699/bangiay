package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.SneakerEntity;
import bandat.repository.custom.SneakerRepositoryCustom;

public interface SneakerRepository extends JpaRepository<SneakerEntity, Long> ,SneakerRepositoryCustom{
	
}
