package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.Departamento;
import com.fantasticCode.repositories.DepartamentRepository;

@Service
public class DepartamentServiceImpl implements DepartamentService {

	@Autowired
	DepartamentRepository departamentoRepository;

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return departamentoRepository.findAll();
	}

}
