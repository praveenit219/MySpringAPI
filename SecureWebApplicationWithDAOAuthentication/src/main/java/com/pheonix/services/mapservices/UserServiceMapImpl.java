package com.pheonix.services.mapservices;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pheonix.domain.DomainObject;
import com.pheonix.domain.User;
import com.pheonix.services.UserService;
import com.pheonix.services.security.EncryptionService;

@Service
@Profile("map")
public class UserServiceMapImpl extends AbstractMapService implements UserService {

	private EncryptionService encryptionService;

	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	@Override
	public User getById(Integer id) {

		return (User) super.getById(id);
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		if(domainObject.getPassword() != null){
			domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
		}

		return (User) super.saveOrUpdate(domainObject);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	public User findByUsername(String userName) {
		Optional returnUser = domainMap.values().stream().filter(new Predicate<DomainObject>() {

			@Override
			public boolean test(DomainObject domainObject) {
				User user = (User) domainObject;
				return user.getUsername().equalsIgnoreCase(userName);
			}

		}).findFirst();

		return (User) returnUser.get();
	}

}
