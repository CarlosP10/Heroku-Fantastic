package com.fantasticCode.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "public", name = "table_user")
public class User {
	@Id
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_seq", sequenceName = "public.user_seq", allocationSize = 1)
	@Column(name = "id_user")
	private Integer iduser;

	@Column(name = "name")
	private String name;

	@Column(name = "u_lastname")
	private String ulastname;

	@Column(name = "u_birthdate")
	private String ubirthdate;

	@Column(name = "country")
	private String country;

	@Column(name = "municipality")
	private String municipality;

	@Column(name = "address")
	private String address;

	@Column(name = "creation_date_hour")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_date_hour;

	@Column(name = "c_contact")
	private String contact;

	@Column(name = "c_description")
	private String description;

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUlastname() {
		return ulastname;
	}

	public void setUlastname(String ulastname) {
		this.ulastname = ulastname;
	}

	public String getUbirthdate() {
		return ubirthdate;
	}

	public void setUbirthdate(String ubirthdate) {
		this.ubirthdate = ubirthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreation_date_hour() {
		return creation_date_hour;
	}

	public void setCreation_date_hour(Date creation_date_hour) {
		this.creation_date_hour = creation_date_hour;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User(Integer iduser, String name, String ulastname, String ubirthdate, String country, String municipality,
			String address, Date creation_date_hour, String contact, String description) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.ulastname = ulastname;
		this.ubirthdate = ubirthdate;
		this.country = country;
		this.municipality = municipality;
		this.address = address;
		this.creation_date_hour = creation_date_hour;
		this.contact = contact;
		this.description = description;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
