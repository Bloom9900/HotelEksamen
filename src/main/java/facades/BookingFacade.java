package facades;

import dto.BookingDTO;
import entities.Booking;
import entities.Creditcard;
import entities.Customer;
import entities.Hotel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BookingFacade {

    private static BookingFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BookingFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BookingFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookingFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BookingDTO makeBooking(
            String username,
            String password,
            String cardnumber,
            String phoneNumber,
            int expirationMonth,
            int expirationYear,
            String cardholder,
            String cardtype,
            int amountOfNights,
            String pricePrNight,
            String startDate,
            Long id,
            String address,
            String hotelName,
            String hotelPhone
    ) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            String expoDate = Integer.toString(expirationMonth) + Integer.toString(expirationYear);
            Creditcard creditcard = new Creditcard(cardtype, cardnumber, expoDate, cardholder);
            Customer customer = em.find(Customer.class, username);
            Hotel hotel = em.find(Hotel.class, id);
            if (hotel == null) {
                hotel = new Hotel(hotelName, address, hotelPhone);
                em.persist(hotel);
            }
            if (customer == null) {
                customer = new Customer(username, password, cardholder, phoneNumber);
                em.persist(customer);
            }
            Booking booking = new Booking(startDate, amountOfNights, pricePrNight);
            hotel.setId(id);
            booking.setHotel(hotel);
            customer.addCreditcard(creditcard);
            creditcard.setCustomer(customer);
            booking.setCustomer(customer);
            hotel.addBooking(booking);
            customer.addBooking(booking);
            em.persist(booking);
            em.getTransaction().commit();
            return new BookingDTO(booking);
        } finally {
            em.close();
        }
    }

//    public List<Booking> getBookings(String username) {
//        EntityManager em = getEntityManager();
//        try {
//            TypedQuery<Booking> query = em.createQuery("SELECT b FROM Bookings b WHERE b.user_name = :username", Booking.class);
//            query.setParameter("username", username);
//            List<Booking> bookings = query.getResultList();
//            return bookings;
//        } finally {
//            em.close();
//        }
//    }
}
