package utils;

import entities.Customer;
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

    Customer user = new Customer("testNavn", "user", "test1", "23656270");
    Customer admin = new Customer("adminNavn", "admin", "test1", "65748410");
    Customer both = new Customer("mixbruger", "user_admin", "test1", "87451945");

    if(admin.getPassword().equals("test")||user.getPassword().equals("test")||both.getPassword().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

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
    em.getTransaction().commit();
    System.out.println("PW: " + user.getPassword());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test1"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test"));
    System.out.println("Created TEST Users");
  }

}