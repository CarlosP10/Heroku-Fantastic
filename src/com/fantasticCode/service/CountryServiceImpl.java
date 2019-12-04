package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.Countries;
import com.fantasticCode.repositories.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository paisRepository;

	public List<Countries> findAll() {
		// TODO Auto-generated method stub
		return paisRepository.findAll();
	}

}
