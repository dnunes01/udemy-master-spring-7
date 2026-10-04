package com.eazybytes.ex7.config;

import com.eazybytes.ex7.beans.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example7 {

    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectScopeConfig.class);

        var myService1 = context.getBean(MyService.class);
        var myService2 = context.getBean(MyService.class);

        System.out.println(myService1.hashCode());
        System.out.println(myService2.hashCode());
    }
}
