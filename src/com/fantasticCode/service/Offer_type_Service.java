package com.fantasticCode.service;

import java.util.List;

import com.fantasticCode.entities.Offer_type;

//interfaz del tipo de oferta (manipulacion)

public interface Offer_type_Service {
	public List<Offer_type> findAll(int page);

	public List<Offer_type> findAll();

	public Offer_type findOne(Integer code);

	public long countAll();

	public void save(Offer_type ticket_type);

	public void delete(Offer_type ticket_type);

}
