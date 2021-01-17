package dto;

import entities.Booking;
import entities.Hotel;
import java.util.Set;

public class HotelDTO {
    private Long id;
    private String name;
    private String content;
    private String email;
    private String directions;
    private String phone;
    private String price;
    private String url;
    private String address;
    private Set<Booking> bookings;

    public HotelDTO(Hotel h) {
        this.id = h.getId();
        this.name = h.getName();
        this.phone = h.getPhone();
        this.address = h.getAddress();
        if(bookings != null) {
            this.bookings = h.getBookings();
        }
    }

    public HotelDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
