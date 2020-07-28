package bandat.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import bandat.entity.SneakerEntity;
import bandat.repository.custom.SneakerRepositoryCustom;

@Repository
public class SneakerRepositoryImpl implements SneakerRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<SneakerEntity> listSneakerByBrandId(Long brandId) {
		String sql="select * from sneaker where brandSneakerId="+brandId;
		Query query=entityManager.createNativeQuery(sql,SneakerEntity.class);
		return query.getResultList();
	}

}
