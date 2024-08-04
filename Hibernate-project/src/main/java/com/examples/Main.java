package com.examples;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
    	Employee e1=new Employee("Kabir Singh","Manager",67000);
    	Employee e2=new Employee("Srirsm","Clerk",50000);
    	Transaction trns=null;
    	try(Session session=HUtil.getSesFactory().openSession()){
    		trns=session.beginTransaction();
    		session.persist(e1);
    		session.persist(e2);
    		trns.commit();
    	}
    	catch(Exception e) {
    		if(trns!=null)
    			trns.rollback();
    		e.printStackTrace();
    	}
    	
        } 
}
