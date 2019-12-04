package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.Offer_type;
import com.fantasticCode.repositories.Offer_type_Repository;

@Service
public class Offer_type_ServiceImpl implements Offer_type_Service {

	@Autowired
	Offer_type_Repository offer_type_Repository;

	public List<Offer_type> findAll(int page) {
		// TODO Auto-generated method stub
		return offer_type_Repository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idtype"))).getContent();
	}

	public Offer_type findOne(Integer offer_type) {
		// TODO Auto-generated method stub
		return offer_type_Repository.findById(offer_type).get();
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return offer_type_Repository.count();
	}

	public void save(Offer_type offer_type) {
		offer_type_Repository.save(offer_type);
	}

	@Override
	public void delete(Offer_type offer_type) {
		offer_type_Repository.delete(offer_type);

	}

	@Override
	public List<Offer_type> findAll() {
		// TODO Auto-generated method stub
		return offer_type_Repository.findAll();
	}
}
