package bandat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.BrandSneakerEntity;
import bandat.repository.custom.BrandSneakerRepositoryCustom;

public interface BrandSneakerRepository extends JpaRepository<BrandSneakerEntity,Long>,BrandSneakerRepositoryCustom{
	BrandSneakerEntity findByNameIgnoreCaseAndStatus(String name,int status);
	BrandSneakerEntity findById(Long id);
	List<BrandSneakerEntity> findByStatus(int status);
}
