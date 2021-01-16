package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.CustomerFacade;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("customer")
public class CustomerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final CustomerFacade facade =  CustomerFacade.getCustomerFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @GET
    @Path("{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomer(@PathParam("username") String username) {
        return gson.toJson(facade.getCustomer(username));
    }
}
