package com.cont;

import com.mysql.cj.jdbc.Blob;

public class Patient {
	 
	    private String pname;
	    private String address;
	    private String gender;
	    private Blob prescription;
	    private int pid;
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
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
		public Blob getPrescription() {
			return prescription;
		}
		}
	    

