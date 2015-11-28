package lastSeen.rest.services;

import lastSeen.DataBase.DAO.MissingPersonDAO;
import lastSeen.rest.services.result.RestResult;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by yoavsusan on 11/27/2015.
 */
@Path("/missingPersonRest")
public class missingPersonRest implements  restService{
    @Context
    private HttpServletRequest httpServletRequest;
    @Context
    private HttpServletRequest httpServletResponse;

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    @GET
    @Path("/getAllMissingPersons")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult getAllMissingPersons() {
        return new RestResult(true, "success",  MissingPersonDAO.findAll());
    }
}
