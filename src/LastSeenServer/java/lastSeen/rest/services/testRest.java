package lastSeen.rest.services;

import lastSeen.DataBase.DAO.ContactDAO;
import lastSeen.rest.services.result.RestResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/testRest")
public class testRest implements restService {

    @Context
    private HttpServletRequest httpServletRequest;

    public HttpServletRequest getHttpServletRequest(){
        return httpServletRequest;
    }

    @Context
    private HttpServletResponse httpServletResponse;

    @GET
    @Path("/sayHello")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult func(@QueryParam("name")String name){
        return new RestResult(true, "Hello " + name);
    }




    @GET
    @Path("/findAllContacts")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult func1(){

        return new RestResult(true, "success" ,ContactDAO.findAll());
    }

}