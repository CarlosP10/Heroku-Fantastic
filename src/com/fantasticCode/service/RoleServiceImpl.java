package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.Role;
import com.fantasticCode.repositories.RoleRepository;;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> findAll(int page) {
		// TODO Auto-generated method stub
		return roleRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idrole"))).getContent();
	}

	public Role findOne(Integer role) {
		// TODO Auto-generated method stub
		return roleRepository.findById(role).get();
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return roleRepository.count();
	}

	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);

	}
}
