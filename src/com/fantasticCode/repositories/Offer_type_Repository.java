package com.fantasticCode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fantasticCode.entities.Offer_type;

public interface Offer_type_Repository extends JpaRepository<Offer_type, Integer> {

	public List<Offer_type> findAll();
}
