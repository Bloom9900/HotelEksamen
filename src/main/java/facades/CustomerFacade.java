package facades;

import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer getVerifiedCustomer(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        Customer customer;
        try {
            customer = em.find(Customer.class, username);
            if (customer == null || !customer.verifyPassword(password)) {
                throw new AuthenticationException("Invalid username or password");
            }
        } finally {
            em.close();
        }
        return customer;
    }
}
