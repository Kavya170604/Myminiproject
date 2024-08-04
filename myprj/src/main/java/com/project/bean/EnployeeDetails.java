package com.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP_DETAILS")
public class EnployeeDetails {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID",nullable=false,unique=true)
   private long empid;
	private String address;
	private String gender;
	@Column(name="YEARS_OF_SERVICE")
	private long yearsOfService;
	@Column(name="BANK_ACCOUNT")
			private String bankAccount;
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getYearsOfService() {
		return yearsOfService;
	}
	public void setYearsOfService(long yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	@Override
	public String toString() {
		return "EnployeeDetails [empid=" + empid + ", address=" + address + ", gender=" + gender + ", yearsOfService="
				+ yearsOfService + ", bankAccount=" + bankAccount + "]";
	}

}
