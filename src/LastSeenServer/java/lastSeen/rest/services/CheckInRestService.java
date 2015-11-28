package lastSeen.rest.services;

import lastSeen.DataBase.DAO.CheckInDAO;
import lastSeen.DataBase.dbObjects.CheckIn;
import lastSeen.rest.services.result.RestResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by kabessa on 28/11/2015.
 */
@Path("/checkIn")
public class CheckInRestService implements RestService {

        @Context
        private HttpServletRequest httpServletRequest;

        public HttpServletRequest getHttpServletRequest(){
            return httpServletRequest;
        }

        @Context
        private HttpServletResponse httpServletResponse;

        @GET
        @Path("/getAllCheckIns")
        @Produces(MediaType.APPLICATION_JSON)
        public RestResult getAllCheckIns(){
            List<CheckIn> checkInsList = CheckInDAO.findAll();
            return new RestResult(true, "getAllCheckIns",checkInsList);
        }


        @POST
        @Path("/addCheckIn")
        @Produces(MediaType.APPLICATION_JSON)
        public RestResult addCheckIn(CheckIn checkIn){
            try {
                CheckInDAO.add(checkIn);
            }
            catch(Exception e) {
                return new RestResult(false, e.getMessage());
            }
            return new RestResult(true, "Add Succeeded");
        }

        @POST
        @Path("/updateCheckin")
        @Produces(MediaType.APPLICATION_JSON)
        public RestResult updateCheckin(CheckIn checkIn) {
            try {
                CheckInDAO.update(checkIn);
            } catch (Exception e) {
                return new RestResult(false, "Update Failed "+ e.getMessage());
            }
            return new RestResult(true, "Update Succeeded");
        }

        @POST
        @Path("/deleteCheckIn")
        @Produces(MediaType.APPLICATION_JSON)
        public RestResult deleteCheckIn(CheckIn checkIn) {
            try {
                CheckInDAO.delete(checkIn);
            } catch (Exception e) {
                return new RestResult(false, "Delete Failed " + e.getMessage());
            }
            return new RestResult(true, "Delete Succeeded");
        }
}
