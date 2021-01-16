package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.HotelDTO;
import facades.CustomerFacade;
import java.io.IOException;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

//Todo Remove or change relevant parts before ACTUAL use
@Path("hotel")
public class HotelResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final CustomerFacade facade =  CustomerFacade.getCustomerFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String externalEndpoint = "http://exam.cphdat.dk:8000/";
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getHotels() throws IOException {
        String hotels = HttpUtils.fetchData(externalEndpoint + "hotel/all");
        HotelDTO[] hotelsDTO = gson.fromJson(hotels, HotelDTO[].class);
        return gson.toJson(hotelsDTO);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getHotel(@PathParam("id") int id) throws IOException {
        String hotel = HttpUtils.fetchData(externalEndpoint + "hotel/" + id);
        HotelDTO hotelDTO = gson.fromJson(hotel, HotelDTO.class);
        return gson.toJson(hotelDTO);
    }
}
