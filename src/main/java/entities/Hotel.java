package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name = "Hotel.deleteAllRows", query = "DELETE from Hotel"),
@NamedQuery(name = "Hotel.getAllRows", query = "SELECT h FROM Hotel h")})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    
    private String name;
    private String address;
    private String phone;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
    private Set<Booking> bookings;

    public Hotel() {
    }

    public Hotel(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bookings = new HashSet();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public void addBooking(Booking booking) {
        if (booking != null) {
            booking.setHotel(this);
            this.bookings.add(booking);
        }
    }
    
    
}
