package com.fantasticCode.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fantasticCode.entities.Account;
import com.fantasticCode.entities.Reservation;
import com.fantasticCode.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	public List<Reservation> findAll(int page) {
		// TODO Auto-generated method stub
		return reservationRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idreservation")))
				.getContent();
	}

	public List<Reservation> findAll(int page, Account id) {
		// TODO Auto-generated method stub
		return reservationRepository
				.findByAccount(id, PageRequest.of(page, 10, new Sort(Direction.ASC, "idreservation"))).getContent();
	}

	/*
	 * public List<Reservation> findAll(Date start,Date end,int page,Account id) {
	 * // TODO Auto-generated method stub return
	 * reservationRepository.findByTransactiondatehourBetweenAndAccount(start,end,id
	 * ,PageRequest.of(page, 10, new Sort(Direction.ASC,
	 * "idtransaction"))).getContent(); }
	 */

	public Reservation findOne(Integer transaction) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(transaction).get();
	}

	public long countAll() {
		// TODO Auto-generated method stub
		return reservationRepository.count();
	}

	/*
	 * public long countAll(Date start,Date end,int page,Account id) { // TODO
	 * Auto-generated method stub return
	 * reservationRepository.findByTransactiondatehourBetweenAndAccount(start,end,id
	 * ).size(); }
	 */
	@Transactional
	public void save(Reservation transaction) {
		reservationRepository.save(transaction);
	}

	@Transactional
	@Override
	public void delete(Reservation transaction) {
		reservationRepository.delete(transaction);

	}

	@Override
	public List<Reservation> findAll(Date start, Date end, int page, Account id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAll(Date start, Date end, int page, Account id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
