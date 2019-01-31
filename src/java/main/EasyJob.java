/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import jobs.service.ClientServices;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import jobs.service.ApplicantServices;
import jobs.service.JobService;

/**
 * REST Web Service
 *
 * @author mahes
 */
@Path("easyjob")
public class EasyJob {

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
    @Path("getallclients")
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

    @POST
    @Path("updateclient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String updateClientData(String json) {

        boolean getResponse = new ClientServices().updateClient(json);
        if (getResponse) {
            return "data updated";
        } else {
            return "data not updated";
        }
    }

    @POST
    @Path("getclientinfo")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_HTML)
    public String getClientData(String user_name) {
        return new ClientServices().getClient(user_name);
    }

    // Applicant Class Methods
    @GET
    @Path("getallapplicants")
    @Produces(MediaType.TEXT_PLAIN)
    public String getApplicantData() {
        //TODO return proper representation object
        return new ApplicantServices().getAllApplicants().toString();
    }

    @POST
    @Path("addapplicant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String addApplicantData(String json) {

        boolean getResponse = new ApplicantServices().addApplicant(json);
        if (getResponse) {
            return "data inserted";
        } else {
            return "data not inserted";
        }
    }

    @POST
    @Path("updateclient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String updateApplicantData(String json) {

        boolean getResponse = new ApplicantServices().updateApplicant(json);
        if (getResponse) {
            return "data updated";
        } else {
            return "data not updated";
        }
    }

    @POST
    @Path("getapplicantinfo")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_HTML)
    public String getApplicantData(String user_name) {
        return new ApplicantServices().getApplicant(user_name);
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

    @POST
    @Path("updatejob")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String updateJob(String json) {

        boolean getResponse = new JobService().updateJob(json);
        if (getResponse) {
            return "data updated";
        } else {
            return "data not updated";
        }
    }

    @POST
    @Path("getjobsbyclient")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJobsByClient(String id) {
        //TODO return proper representation object
        return new JobService().getAllJobsByClient(Integer.parseInt(id)).toString();
    }

}
