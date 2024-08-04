package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dev.product;

public class Manager1 {
public static void main(String args[]) {
	AnnotationConfiguration cfg=new AnnotationConfiguration();
	cfg.configure("Resources/hibernate.bcfg.xml");
	SessionFactory session = cfg.buildSessionFactory();
	Session sess = session.openSession();
	Transaction trns =sess.beginTransaction();
	product product=new product();
	product.setP_id(1);
	product.setP_name("hari");
	product.setQty(2);
	
	sess.save(product);
	trns.commit();
	System.out.print("Done");
}
}
