package com.fantasticCode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "table_offer_type")
public class Offer_type {
	@Id
	@Column(name = "id_type")
	private Integer idtype;

	@Column(name = "type")
	private String type;

	public Integer getIdtype() {
		return idtype;
	}

	public void setIdtype(Integer idtype) {
		this.idtype = idtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Offer_type(Integer idtype, String type) {
		super();
		this.idtype = idtype;
		this.type = type;
	}

	public Offer_type() {
		super();
		// TODO Auto-generated constructor stub
	}

}
