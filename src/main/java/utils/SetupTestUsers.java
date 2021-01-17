package utils;

import entities.Booking;
import entities.Creditcard;
import entities.Customer;
import entities.Hotel;
import entities.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
    
    Customer user = new Customer("user", "test1", "testNavn", "23656270");
    Customer admin = new Customer("admin", "test1", "adminNavn", "65748410");
    Customer both = new Customer("user_admin", "test1", "mixbruger", "87451945");
    
//    Creditcard card = new Creditcard("visa", "561898156", "1221", "Jannich");
//    Hotel hotel = new Hotel("Hotel Lotus", "Engvej 42", "2346235423");
//    hotel.setId(2L);
////    Booking booking = new Booking("I dag", 2, 50);
//    user.addCreditcard(card);
//    card.setCustomer(user);
//    hotel.addBooking(booking);
//    user.addBooking(booking);
//    booking.setHotel(hotel);
//    booking.setCustomer(user);
    

//    if(admin.getPassword().equals("test")||user.getPassword().equals("test")||both.getPassword().equals("test"))
//      throw new UnsupportedOperationException("You have not changed the passwords");

//    Booking booking2 = new Booking("I morgen", 3, 60);
//    booking2.setHotel(hotel);
//    booking2.setCustomer(user);
//    hotel.addBooking(booking2);
//    user.addBooking(booking2);

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
//    em.persist(booking);
//        em.persist(hotel);
//    em.persist(booking2);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getPassword());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test1"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test"));
    System.out.println("Created TEST Users");


  }

}
