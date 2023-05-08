package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResponse hello() {
        // print env
        System.getenv().forEach((k, v) -> System.out.println(k + " => " + v));

        // return response
        return new HelloResponse("Hello Again");
    }

}