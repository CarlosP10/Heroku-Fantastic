package com.fantasticCode.service;

import java.util.Date;
import java.util.List;

import com.fantasticCode.entities.Account;
import com.fantasticCode.entities.Reservation;

public interface ReservationService {
	public List<Reservation> findAll(int page);

	public Reservation findOne(Integer code);

	public long countAll();

	public void save(Reservation transaction);

	public void delete(Reservation transaction);

	public List<Reservation> findAll(int page, Account id);

	public List<Reservation> findAll(Date start, Date end, int page, Account id);

	public long countAll(Date start, Date end, int page, Account id);
}
