package bandat.repository.custom;

import java.util.List;

import bandat.entity.SneakerEntity;

public interface SneakerRepositoryCustom {
	public List<SneakerEntity> listSneakerByBrandId(Long brandId);
}
