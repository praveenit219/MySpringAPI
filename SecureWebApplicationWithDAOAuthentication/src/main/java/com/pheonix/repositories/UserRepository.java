package com.pheonix.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pheonix.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	 User findByUsername(String username);

}
