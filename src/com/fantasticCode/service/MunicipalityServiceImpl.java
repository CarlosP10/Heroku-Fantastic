package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.Municipio;
import com.fantasticCode.repositories.MunicipalityRepository;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

	@Autowired
	MunicipalityRepository municipioRepository;

	public List<Municipio> findAll() {
		// TODO Auto-generated method stub
		return municipioRepository.findAll();
	}

}
