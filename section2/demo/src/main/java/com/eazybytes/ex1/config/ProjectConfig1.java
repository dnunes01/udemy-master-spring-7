package com.eazybytes.ex1.config;

import com.eazybytes.ex1.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
 */
@Configuration
public class ProjectConfig1 {

    /*
    @Bean annotation, which lets Spring know that it needs to call
    this method when it initializes its context and adds the returned
    value to the context.
     */
    @Bean (name="audiVehicle")
    @Description("Represents a Vehicle of type Audi")
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Primary
    @Bean (value="hondaVehicle")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Bean ({"ferrariVehicle", "myFavVehicle"})
    @Description("Represents a Vehicle of type Ferrari")
    Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }



}
