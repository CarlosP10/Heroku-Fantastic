package com.fantasticCode.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fantasticCode.entities.Account;
import com.fantasticCode.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	public Page<Reservation> findAll(Pageable page);

	public Page<Reservation> findByAccount(Account account, Pageable page);
	/*
	 * public Page<Reservation> findByTransactiondatehourBetweenAndAccount(Date
	 * start,Date end,Account a,Pageable page);
	 * 
	 * public List<Reservation> findByTransactiondatehourBetweenAndAccount(Date
	 * start,Date end,Account a);
	 */

}
