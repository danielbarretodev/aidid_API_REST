package com.aidid.security.service.impl;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Organization;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.security.dto.UserDto;
import com.aidid.security.entity.Role;
import com.aidid.security.entity.RoleEnum;
import com.aidid.security.entity.User;
import com.aidid.security.entity.UserTypeEnum;
import com.aidid.security.repository.RoleRepository;
import com.aidid.security.repository.UserRepository;
import com.aidid.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private SolidarityHistoryRepository solidarityHistoryRepository;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
    public User save(User user) throws Exception {
			
			if (user instanceof Collaborator) {
				user = new Collaborator();
				SolidarityHistory sh = new SolidarityHistory();
				this.solidarityHistoryRepository.save(sh);
					
			} else {
				user = new Organization();	
			}
			    
	        return userRepository.save(user);
    }
}
