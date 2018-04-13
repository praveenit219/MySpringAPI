package com.pheonix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pheonix.domain.Role;
import com.pheonix.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository roleRepository;
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	
	@Override
	public List<?> listAll() {
		List<Role> roles = new ArrayList<>();
		roleRepository.findAll().forEach(roles::add); 
		
		return roles;
	}

	@Override
	public Role getById(Integer id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

	@Override
	public Role saveOrUpdate(Role domainObject) {
		// TODO Auto-generated method stub
		return roleRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.delete(id);
		
	}

}
