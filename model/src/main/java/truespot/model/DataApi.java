package truespot.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/api")
@Api(value = "/", description = "")
public interface DataApi {

    @GET
    @Path("/user")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "", tags = {"data"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request ", response = User.class)
    })
    Response user();

}


