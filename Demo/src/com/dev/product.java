package com.dev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="Products")
public class product {
	@Id
 private int P_id;
	@Column
 private String P_name;
 private int Qty;
public int getP_id() {
	return P_id;
}
public void setP_id(int p_id) {
	P_id = p_id;
}
public String getP_name() {
	return P_name;
}
public void setP_name(String p_name) {
	P_name = p_name;
}
public int getQty() {
	return Qty;
}
public void setQty(int qty) {
	Qty = qty;
}
}
