package entities;

import java.io.Serializable;
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
@NamedQuery(name = "Creditcard.deleteAllRows", query = "DELETE from Creditcard"),
@NamedQuery(name = "Creditcard.getAllRows", query = "SELECT c FROM Creditcard c")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type;
    private String cardNumber;
    private String expoDate;
    private String nameOfHolder;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Creditcard() {
    }

    public Creditcard(String type, String cardNumber, String expoDate, String nameOfHolder) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.expoDate = expoDate;
        this.nameOfHolder = nameOfHolder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpoDate() {
        return expoDate;
    }

    public void setExpoDate(String expoDate) {
        this.expoDate = expoDate;
    }

    public String getNameOfHolder() {
        return nameOfHolder;
    }

    public void setNameOfHolder(String nameOfHolder) {
        this.nameOfHolder = nameOfHolder;
    }
}