package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fantasticCode.entities.Offer;
import com.fantasticCode.repositories.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferRepository offerRepository;

	public List<Offer> findAll(int page) {
		// TODO Auto-generated method stub
		return offerRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idoffer"))).getContent();
	}

	public Offer findOne(Integer offer) {
		// TODO Auto-generated method stub
		return offerRepository.findById(offer).get();
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return offerRepository.count();
	}

	@Transactional
	public void save(Offer film) {
		offerRepository.save(film);
	}

	@Transactional
	@Override
	public void delete(Offer offer) {
		offerRepository.delete(offer);

	}

	@Override
	public List<Offer> findAll() {
		// TODO Auto-generated method stub
		return offerRepository.findAll();
	}

	@Override
	public List<Offer> findAllActive() throws DataAccessException {
		// TODO Auto-generated method stub
		return offerRepository.findAllbyState();
	}

}
