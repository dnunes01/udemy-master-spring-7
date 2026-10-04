package com.eazybytes.demo;


import com.eazybytes.demo.config.ProjectConfig;
import com.eazybytes.demo.beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMainClass {

    static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        /*
        We don't need to do any explicit casting while fetching a bean from context.
        Spring is smart enough to look for a bean of the type you requested in its context.
        If such a bean doesn't exist, Spring will throw an exception.
         */
        String hello = context.getBean(String.class);
        System.out.println("Hello from Spring Context is: " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Number from Spring Context is: " + num);

        /*
        When searching for Bean by its name, type-casting will be required, as in this example
         */
        String hello1 = (String) context.getBean("hello");
        System.out.println("Hello from Spring Context using Bean name: " + hello1);

        // context.getBean(Double.class);
    }

}
