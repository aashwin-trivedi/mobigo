package com.mobigo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable{

	@Id
	private int cartid;
	@Column
	private String cartuser;
	@Column
	private int productid;
	@Column
	private String prodname;
	@Column
	private double prodprice;
	@Column
	private int quantity;
	@Column
	private double carttotal;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getCartuser() {
		return cartuser;
	}
	public void setCartuser(String cartuser) {
		this.cartuser = cartuser;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public double getProdprice() {
		return prodprice;
	}
	public void setProdprice(double prodprice) {
		this.prodprice = prodprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCarttotal() {
		return carttotal;
	}
	public void setCarttotal(double carttotal) {
		this.carttotal = carttotal;
	}
	
}
