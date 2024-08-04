package com.project1.Myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project1.Myapp.config.BeanConfig;
import com.project1.Myapp.config.service.MyappService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
        MyappService myapp=context.getBean(MyappService.class);
        String getDisplay=myapp.Display();
        System.out.println(getDisplay);
        myapp.addBooks("Spring in Action");
        myapp.addBooks("Programming in c");
        myapp.addBooks("Java");
        myapp.getBooksDetails().stream().forEach(e->System.out.println(e));
        System.out.print("Done");
    }
}
