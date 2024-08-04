package com.project.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="asset_mngt")
public class Assestmgnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="am_id",nullable = false,unique = true)
	private long am_id;
	@Column(name="emp_id",nullable=false,unique=true)
	private long eid;
	private String asset_name;
	private String vendor;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	
	public long getAm_id() {
		return am_id;
	}
	public void setAm_id(long am_id) {
		this.am_id = am_id;
	}
	public long getEmp_id() {
		return eid;
	}
	public void setEmp_id(long emp_id) {
		this.eid = emp_id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "assignment [am_id=" + am_id + ", emp_id=" + eid + ", asset_name=" + asset_name + ", vendor=" + vendor
				+ "]";
	}
	

}