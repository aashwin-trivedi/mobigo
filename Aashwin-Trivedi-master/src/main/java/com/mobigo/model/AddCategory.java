package com.mobigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddCategory {
	
	@Id
	private int cid;
	
	@Column
	private String cname;
	
	@Column
	private String catdes;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCatdes() {
		return catdes;
	}

	public void setCatdes(String catdes) {
		this.catdes = catdes;
	}
	
	
	
	
}
