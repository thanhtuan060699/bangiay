package bandat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bandat.entity.UserEntity;
import bandat.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<UserEntity, Long>,UserRepositoryCustom{
	UserEntity findOneByUserNameAndStatus(String name, int status);
	
}
