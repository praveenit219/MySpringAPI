package com.pheonix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pheonix.domain.User;
import com.pheonix.repositories.UserRepository;
import com.pheonix.services.security.EncryptionService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository; 

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private EncryptionService encryptionService;

	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<?> listAll() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add); 
		return users;
	}

	@Override
	public User getById(Integer id) {

		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		if(domainObject.getPassword() != null){
			domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
		}
		return userRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);			

	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}



}
