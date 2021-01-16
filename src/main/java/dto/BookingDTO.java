package dto;

import entities.Booking;
import entities.Creditcard;
import java.util.Set;

public class BookingDTO {
    private String startDate;
    private int amountOfNights;
    private int pricePrNight;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String username;
    private String phone;
    private Set<Creditcard> creditcards;
    
    public BookingDTO(Booking b) {
        this.startDate = b.getStartDate();
        this.amountOfNights = b.getAmountOfNights();
        this.pricePrNight = b.getPricePrNight();
        this.creditcards = b.getCustomer().getCreditcards();
        if(b.getCustomer() != null) {
            this.username = b.getCustomer().getUsername();
            this.phone = b.getCustomer().getPhone();
        }
        if(b.getHotel() != null) {
            this.hotelName = b.getHotel().getName();
            this.hotelAddress = b.getHotel().getAddress();
            this.hotelPhone = b.getHotel().getPhone();
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAmountOfNights() {
        return amountOfNights;
    }

    public void setAmountOfNights(int amountOfNights) {
        this.amountOfNights = amountOfNights;
    }

    public int getPricePrNight() {
        return pricePrNight;
    }

    public void setPricePrNight(int pricePrNight) {
        this.pricePrNight = pricePrNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Creditcard> getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(Set<Creditcard> creditcards) {
        this.creditcards = creditcards;
    }
}
