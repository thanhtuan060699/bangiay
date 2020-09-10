package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	public RoleEntity findById(Long id);
}
