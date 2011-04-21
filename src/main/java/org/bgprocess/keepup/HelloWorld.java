package org.bgprocess.keepup;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorld {
    @GET 
    @Produces("text/plain")
    public String sayHelloWorld() {
        return "Hello World!";
    }
}
