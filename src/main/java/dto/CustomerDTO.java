package dto;

import entities.Booking;
import entities.Creditcard;
import entities.Customer;
import java.util.Set;

public class CustomerDTO {
    private String username;
    private String password;
    private String fullname;
    private String phoneNumber;
    private Set<Creditcard> creditcards;
    private Set<Booking> bookings;

    public CustomerDTO(Customer c) {
        this.username = c.getUsername();
        this.password = c.getPassword();
        this.fullname = c.getFullname();
        this.phoneNumber = c.getPhoneNumber();
        if(c.getCreditcards() != null) {
            this.creditcards = c.getCreditcards();
        }
        if(c.getBookings() != null) {
            this.bookings = c.getBookings();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Creditcard> getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(Set<Creditcard> creditcards) {
        this.creditcards = creditcards;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    
    
}
