package com.examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main1 {

	public static void main(String args[]) {
		  Transaction trans=null;
		  try(Session session=HUtil.getSesFactory().openSession()){
			  trans=session.beginTransaction();
			  List<Employee> li=session.createQuery("from Employee",Employee.class).list();
			  //Employee[] e=(Employee[])li.toArray();
			  System.out.println("NAME\t DESIGNATION\t SALARY");
			  //li.forEach(e->{System.out.println(e.getName()+"\t"+e.getDesignation()+"\t"+e.getSalary())});
			  for(Employee e:li) {
				  System.out.println(e.getName()+"\t"+e.getDesignation()+"\t"+e.getSalary());
			  }
			  trans.commit();
		  }
		  catch(Exception e) {
			  if(trans!=null)
				  trans.rollback();
			  e.printStackTrace();
		  }
	}
	

}
