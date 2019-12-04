package com.fantasticCode.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fantasticCode.entities.Offer;

//interfaz de ofertas (manipulacion)

public interface OfferService {
	public List<Offer> findAll(int page);

	public List<Offer> findAll();

	public Offer findOne(Integer code);

	public long countAll();

	public void save(Offer film);

	public void delete(Offer film);

	public List<Offer> findAllActive() throws DataAccessException;
}
