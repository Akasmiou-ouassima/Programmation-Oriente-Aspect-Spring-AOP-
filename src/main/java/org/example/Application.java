package org.example;

import org.example.aspects.SecurityContext;
import org.example.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class Application {
    public static void main(String[] args) {
        try {
            SecurityContext.authenticate("root","1234",new String[]{"USER","ADMIN"});
            ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
            IMetier metier=applicationContext.getBean(IMetier.class);
            System.out.println("********************");
            System.out.println(metier.getClass().getName());
            System.out.println("********************");
            metier.process();
            System.out.println(metier.compute());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
@Configuration
@ComponentScan("org.example")
class MyConfig{
}
