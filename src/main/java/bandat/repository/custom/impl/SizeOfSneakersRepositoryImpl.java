package bandat.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import bandat.entity.SizeOfSneakersEntity;
import bandat.repository.custom.SizeOfSneakersRepositoryCustom;

@Repository
public class SizeOfSneakersRepositoryImpl implements SizeOfSneakersRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<SizeOfSneakersEntity> findAllBySneakerId(Long sneakerId) {
		String sql="select * from sizesneaker where sneakerid="+sneakerId+" and amount>0";
		Query query=entityManager.createNativeQuery(sql,SizeOfSneakersEntity.class);
		return query.getResultList();
	}

}
