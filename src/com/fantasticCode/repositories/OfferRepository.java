package com.fantasticCode.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fantasticCode.entities.Offer;

public interface OfferRepository extends PagingAndSortingRepository<Offer, Integer> {

	public Page<Offer> findAll(Pageable page);

	public List<Offer> findAll();

	@Query(nativeQuery = true, value = "select DISTINCT offer_id, offer_name, description, duration, url_poster, availability, start_date, end_date, code"
			+ "state, price_range, id_offer_type, creation_date_hour\r\n" + "	from table_offer"
			+ "	WHERE fu.active_state=1")
	public List<Offer> findAllbyState() throws DataAccessException;
}
