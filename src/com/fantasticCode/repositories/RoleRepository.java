package com.fantasticCode.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fantasticCode.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Page<Role> findAll(Pageable page);
}
