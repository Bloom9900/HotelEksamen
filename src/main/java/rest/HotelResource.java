package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.BookingDTO;
import dto.CreditcardDTO;
import dto.CustomerDTO;
import dto.HotelDTO;
import facades.BookingFacade;
import java.io.IOException;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

//Todo Remove or change relevant parts before ACTUAL use
@Path("hotel")
public class HotelResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final BookingFacade facade =  BookingFacade.getFacadeExample(EMF);
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
    
    @POST
    @Path("book")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String makeBooking(String booking) {
        CreditcardDTO creditDTO = gson.fromJson(booking, CreditcardDTO.class);
        HotelDTO hDTO = gson.fromJson(booking, HotelDTO.class);
        CustomerDTO cDTO = gson.fromJson(booking, CustomerDTO.class);
        BookingDTO bDTO = gson.fromJson(booking, BookingDTO.class);
        return gson.toJson(facade.makeBooking
        (
                cDTO.getUsername(), cDTO.getPassword(), creditDTO.getCardnumber(),
                cDTO.getPhoneNumber(), creditDTO.getExpirationMonth(), creditDTO.getExpirationYear(),
                creditDTO.getCardholder(), creditDTO.getType(), bDTO.getAmountOfNights(), bDTO.getPricePrNight(),
                bDTO.getStartDate(), hDTO.getId(), hDTO.getAddress(), hDTO.getName(),
                hDTO.getPhone()
        ));
    }
    
//    @GET
//    @Path("bookings/{username}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getBookings(@PathParam("username") String username) {
//        return gson.toJson(facade.getBookings(username));
//    }
}
