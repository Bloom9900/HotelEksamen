package dto;

import entities.Booking;
import entities.Hotel;
import java.util.Set;

public class HotelDTO {
    private Long hotelId;
    private String hotelName;
    private String content;
    private String email;
    private String directions;
    private String hotelPhone;
    private String price;
    private String url;
    private String address;
    private Set<Booking> bookings;

    public HotelDTO(Hotel h) {
        this.hotelId = h.getId();
        this.hotelName = h.getName();
        this.hotelPhone = h.getPhone();
        this.address = h.getAddress();
        if(bookings != null) {
            this.bookings = h.getBookings();
        }
    }

    public HotelDTO() {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    
    
}
