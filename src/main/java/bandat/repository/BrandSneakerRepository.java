package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.BrandSneakerEntity;
import bandat.repository.custom.BrandSneakerRepositoryCustom;

public interface BrandSneakerRepository extends JpaRepository<BrandSneakerEntity,Long>,BrandSneakerRepositoryCustom{
	BrandSneakerEntity findByNameIgnoreCase(String name);
	BrandSneakerEntity findById(Long id);
}
