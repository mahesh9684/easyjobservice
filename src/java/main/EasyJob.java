/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import jobs.service.ClientServices;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jobs.service.JobService;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author mahes
 */
@Path("easyjob")
public class EasyJob {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EasyJob
     */
    public EasyJob() {
    }

    /**
     * Retrieves representation of an instance of jobs.EasyJob
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getclientdata")
    @Produces(MediaType.TEXT_PLAIN)
    public String getClientData() {
        //TODO return proper representation object
        return new ClientServices().getAllClients().toString();
    }

    @POST
    @Path("addclient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String addClientData(String json) {

        boolean getResponse = new ClientServices().addClient(json);
        if (getResponse) {
            return "data inserted";
        } else {
            return "data not inserted";
        }
    }

    //   Job Class Methods
    @GET
    @Path("getjobs")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJobData() {
        //TODO return proper representation object
        return new JobService().getAllJobs().toString();
    }

    @POST
    @Path("addjob")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String addJob(String json) {

        boolean getResponse = new JobService().addJob(json);
        if (getResponse) {
            return "data inserted";
        } else {
            return "data not inserted";
        }
    }

}
