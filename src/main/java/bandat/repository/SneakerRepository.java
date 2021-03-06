package bandat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.SneakerEntity;
import bandat.repository.custom.SneakerRepositoryCustom;

public interface SneakerRepository extends JpaRepository<SneakerEntity, Long> ,SneakerRepositoryCustom{
	SneakerEntity findByNameIgnoreCase(String name);

}
