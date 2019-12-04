package com.fantasticCode.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "public", name = "table_reservation")
public class Reservation {
	@Id
	@GeneratedValue(generator = "reservation_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "reservation_seq", sequenceName = "public.reservation_seq", allocationSize = 1)
	@Column(name = "id_reservation")
	private Integer idreservation;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_account", referencedColumnName = "id_account")
	private Account account;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_offer", referencedColumnName = "offer_id")
	private Offer offer;

	@Column(name = "reservation_date_hour")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationdatehour;

	public Integer getIdreservation() {
		return idreservation;
	}

	public void setIdreservation(Integer idreservation) {
		this.idreservation = idreservation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Date getReservationdatehour() {
		return reservationdatehour;
	}

	public void setReservationdatehour(Date reservationdatehour) {
		this.reservationdatehour = reservationdatehour;
	}

	public Reservation(Integer idreservation, Account account, Offer offer, Date reservationdatehour) {
		super();
		this.idreservation = idreservation;
		this.account = account;
		this.offer = offer;
		this.reservationdatehour = reservationdatehour;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
