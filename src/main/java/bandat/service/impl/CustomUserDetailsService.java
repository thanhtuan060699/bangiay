package bandat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bandat.constant.SystemConstant;
import bandat.dto.MyUser;
import bandat.entity.RoleEntity;
import bandat.entity.UserEntity;
import bandat.entity.UserRoleEntity;
import bandat.repository.RoleRepository;
import bandat.repository.UserRepository;
import bandat.repository.UserRoleRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		UserRoleEntity userRoleEntity=userRoleRepository.findByUserEntity(userEntity);
		RoleEntity roleEntity=roleRepository.findById(userRoleEntity.getRoleEntity().getId());

		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true,
				authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
