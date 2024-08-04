package com.project.bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//default it has sequence,we use auto bcz of primary key

	@Column(name="Emp_id",nullable=false,unique=true)
	private long eid;
	private String name;
	private String department;
	private long salary;
	private Date joined_on;
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)//fetch reading purpose(onetoone-eager-retrive parent data)
//	@JoinColumn(name="Emp_id")
//	private List<Assestmgnt> assestmgnt;
//	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Emp_id")
	private EnployeeDetails empDetails;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="EMP_ASSINGNMENTS",
    joinColumns = {@JoinColumn(name="EMP_ID")},
    inverseJoinColumns = {@JoinColumn(name="PR__ID")})
    private List<Project> empAssisgnmentList;
	
	
	public EnployeeDetails getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(EnployeeDetails empDetails) {
		this.empDetails = empDetails;
	}
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
//	public List<Assestmgnt> getAssestmgnt() {
//		return assestmgnt;
//	}
//	public void setAssestmgnt(List<Assestmgnt> assestmgnt) {
//		this.assestmgnt = assestmgnt;
//	}
	public long getEmp_id() {
		return eid;
	}
	public void setEmp_id(long emp_id) {
		eid = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Date getJoined_on() {
		return joined_on;
	}
	public void setJoined_on(Date joined_on) {
		this.joined_on = joined_on;
	}
	
	public List<Project> getEmpAssisgnmentList() {
		return empAssisgnmentList;
	}
	public void setEmpAssisgnmentList(List<Project> empAssisgnmentList) {
		this.empAssisgnmentList = empAssisgnmentList;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", joined_on=" + joined_on + ", empDetails=" + empDetails + ", empAssisgnmentList="
				+ empAssisgnmentList + "]";
	}
	
//	
//	@Override
//	public String toString() {
//		return "Employee [Emp_id=" + eid + ", name=" + name + ", department=" + department + ", salary=" + salary
//				+ ", joined_on=" + joined_on + ", assetmgnt=" + assestmgnt + "]";
//	}
	
	
	

	
	
}
