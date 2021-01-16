package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Booking.deleteAllRows", query = "DELETE from Booking"),
@NamedQuery(name = "Booking.getAllRows", query = "SELECT b FROM Booking b")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime startDate;
    private int amountOfNights;
    private int pricePrNight;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Booking() {
    }

    public Booking(int year, int month, int dayOfMont, int hour, int minute, int amountOfNights, int pricePrNight, Customer customer, Hotel hotel) {
        this.startDate = LocalDateTime.of(year, month, dayOfMont, hour, minute);
        this.amountOfNights = amountOfNights;
        this.pricePrNight = pricePrNight;
        this.customer = customer;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}