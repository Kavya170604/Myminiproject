package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.College;
import com.bean.Student;

public class Manager {
    public static void main(String[] args) {
    	
    	/*Student student1=new Student();
    	student1.setS_id(11);
    	student1.setName("kavi");
    	student1.setAddress("karur");
    	student1.setMarks(80);
    	
    	Configuration cfg=new Configuration();
    	cfg.configure("Resources/hibernate.bcfg.xml");
    	//System.out.print("Done");
    	SessionFactory session = cfg.buildSessionFactory();
    	Session sess = session.openSession();
    	Transaction trns =sess.beginTransaction();
    	sess.save(student1);
    	College college1=new College();
    	college1.setId(101);
    	college1.setCname("kavi");
    	college1.setCadd("karur");
    	sess.save(college1);
    	trns.commit();
    	*/
    	Student std=new Student(105,"Raj","karur",99);
    	Student std1=new Student(109,"Ramu","karur",99);
    	Student std2=new Student(10,"kavi","karur",99);
    	Student std3=new Student(103,"navi","karur",99);
    	Configuration cfg=new Configuration();
    	cfg.configure("Resources/hibernate.bcfg.xml");
    	//System.out.print("Done");
    	SessionFactory session = cfg.buildSessionFactory();
    	Session sess = session.openSession();
    	Transaction trns =sess.beginTransaction();
//    	sess.persist(std1);
//    	sess.save(std);
//    	sess.save(std1);
//    	sess.save(std2);
//    	sess.save(std3);
    	Object objData = sess.get(Student.class,new Integer(109));
    	 Student st = (Student) objData;
//    	 st.setS_id(109);
//     	st.setName("kavinila");
//     	st.setAddress("karur");
//     	st.setMarks(80);
//    	 System.out.println(st);
    	 sess.delete(objData);
    	 sess.update(st);
    	trns.commit();
    	
    	
    }
}