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
            int pricePrNight,
            String startDate,
            Long hotelId,
            String address,
            String hotelName,
            String hotelPhone
    ) {
        EntityManager em = getEntityManager();
        String expoDate = Integer.toString(expirationMonth) + Integer.toString(expirationYear);
        Creditcard creditcard = new Creditcard(cardtype, cardnumber, expoDate, cardholder);
        Customer customer = new Customer(username, password, cardholder, phoneNumber);
        creditcard.setCustomer(customer);
        customer.addCreditcard(creditcard);
        Hotel hotel = new Hotel(hotelName, address, hotelPhone);

        Booking booking = new Booking(startDate, amountOfNights, pricePrNight, customer, hotel);
        booking.setCustomer(customer);
        customer.addBooking(booking);
        try {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BookingDTO(booking);
    }

}
