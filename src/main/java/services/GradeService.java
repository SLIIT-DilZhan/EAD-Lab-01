package services;

import beans.GradeManager;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("gradeservice")
public class GradeService {

    @EJB
    GradeManager gm;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String calculateGrade(
            @FormParam("studentName") @DefaultValue("Unknown") String studentName,
            @FormParam("mark") @DefaultValue("0") int mark) {

        String grade = gm.getGrade(mark);

        return "<h2>Student : " + studentName
                + "<br>Mark : " + mark
                + "<br>Grade : " + grade
                + "</h2>";
    }

    @GET
    @Path("getgrade")
    @Produces(MediaType.TEXT_HTML)
    public String getGradeByQuery(
            @QueryParam("name") @DefaultValue("Unknown") String name,
            @QueryParam("mark") @DefaultValue("0") int mark) {

        return "<h2>Student : " + name
                + "<br>Mark : " + mark
                + "<br>Grade : " + gm.getGrade(mark)
                + "</h2>";
    }

    @GET
    @Path("{name}/{mark}")
    @Produces(MediaType.TEXT_HTML)
    public String getGradeByPath(
            @PathParam("name") String name,
            @PathParam("mark") int mark) {

        return "<h2>Student : " + name
                + "<br>Mark : " + mark
                + "<br>Grade : " + gm.getGrade(mark)
                + "</h2>";
    }
}
