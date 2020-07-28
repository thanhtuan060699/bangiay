package bandat.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import bandat.entity.BrandSneakerEntity;
import bandat.repository.custom.BrandSneakerRepositoryCustom;

@Repository
public class BrandSneakerRepositoryImpl implements BrandSneakerRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer totalOfSneakersEachBrand(Long brandId) {
		String sql="select sum(si.amount) from brandsneaker br join sneaker s on br.id=s.brandSneakerId join sizesneaker si on " 
					+ 
				  "s.id=si.sneakerid where br.id="+brandId;
		Query query=entityManager.createNativeQuery(sql);
		Object obj = query.getSingleResult();
	    if (obj != null) {
	        Integer result = Integer.parseInt(obj.toString());
	        return result;
	    }

	    return Integer.valueOf(0);
	}

	@Override
	public List<BrandSneakerEntity> findBrandBySneakerId(Long sneakerId) {
		String sql="select b.* from sneaker s join brandsneaker b on s.brandSneakerId=b.id where s.id="+sneakerId;
		Query query=entityManager.createNativeQuery(sql,BrandSneakerEntity.class);
		return query.getResultList();
	}

	@Override
	public BrandSneakerEntity findByBrandName(String brandName) {
		String sql="select * from brandsneaker where name="+brandName;
		Query query=entityManager.createNativeQuery(sql,BrandSneakerEntity.class);
		return (BrandSneakerEntity) query.getResultList().get(0);
	}

}
