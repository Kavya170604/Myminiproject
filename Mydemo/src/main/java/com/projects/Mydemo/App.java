package com.projects.Mydemo;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.projecst.bean.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       AnnotationConfiguration cfg=new AnnotationConfiguration();
       cfg.configure("./Resources/hibernate.cfg.xml");
       SessionFactory sf=cfg.buildSessionFactory();
       Session session=sf.openSession();
       Transaction trans=session.beginTransaction();
       Student student1=new Student();
       student1.setId(1);
       student1.setName("Navi");
       student1.setAddress("Karur");
       session.save(student1);
       trans.commit();
       Query query=session.createQuery("select s.Name,s.Address from Student s");
       List l1=query.list();
       Iterator it=l1.iterator();
       while(it.hasNext()) {
    	   Object[]o=(Object[])it.next();
    	   System.out.println(o[0]+" , "+o[1]);
       }
       Query query3 =session.createQuery("select s.Name,s.Address from Student s where id=?");
       query3.setParameter(0,3);
       List l3=query3.list();
       l3.stream().forEach(t -> System.out.println("data :"+t));
       Iterator itr=l3.iterator();
       while(itr.hasNext()) {
    	   Object o=itr.next();
       System.out.println(o);
       }
       /*
       Query query=session.createQuery("from Student s");
       List l1=query.list();
       System.out.println(l1);
       l1.stream().forEach(e -> System.out.println());
       ArrayList list=new ArrayList();
       list.add(10);
       list.add("abc");
       list.add("ch");
       System.out.println(list);
       list.stream().forEach(temp -> System.out.println(temp));     
       Iterator it=list.iterator();
       while(it.hasNext()) {
    	   System.out.println(it.next());
       }
      */
     System.out.print("Done");
    }
}
