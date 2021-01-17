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
    private Set<CreditcardDTO> creditcards;
    private Set<BookingDTO> bookings;

    public CustomerDTO(Customer c) {
        this.username = c.getUsername();
        this.password = c.getPassword();
        this.fullname = c.getFullname();
        this.phoneNumber = c.getPhoneNumber();
        if(c.getCreditcards() != null) {
            for (Creditcard creditcard : c.getCreditcards()) {
                creditcards.add(new CreditcardDTO(creditcard));
            }
        }
        if(c.getBookings() != null) {
            for (Creditcard creditcard : c.getCreditcards()) {
                creditcards.add(new CreditcardDTO(creditcard));
            }
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

    public Set<CreditcardDTO> getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(Set<CreditcardDTO> creditcards) {
        this.creditcards = creditcards;
    }

    public Set<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingDTO> bookings) {
        this.bookings = bookings;
    }
}
