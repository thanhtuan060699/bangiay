package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.UserEntity;
import bandat.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{
	public UserRoleEntity  findByUserEntity(UserEntity userEntity);
}
