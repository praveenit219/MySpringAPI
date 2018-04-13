package com.pheonix.services;

import com.pheonix.domain.User;

public interface UserService  extends CRUDService<User>{
	User findByUsername(String username);

}
