package com.examples;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HUtil {

	public static StandardServiceRegistry reigstry=null;
	public static SessionFactory sesFactory=null;
	public static SessionFactory getSesFactory() {
		if(sesFactory==null) {
			try {
				//create registry
				reigstry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				//create MetadataSources
				MetadataSources sources=new MetadataSources(reigstry);
				//create Metadata
				Metadata metadata=sources.getMetadataBuilder().build();
				//Create SessionFactory
				sesFactory=metadata.getSessionFactoryBuilder().build();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				if(reigstry!=null) {
					StandardServiceRegistryBuilder.destroy(reigstry);
				}
			}
		}
		return sesFactory;
	}

}
