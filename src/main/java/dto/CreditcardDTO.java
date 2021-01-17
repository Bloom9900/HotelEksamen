package dto;

import entities.Creditcard;

public class CreditcardDTO {
    private String cardnumber;
    private int expirationMonth;
    private int expirationYear;
    private String cardholder;
    private String type;

    public CreditcardDTO(Creditcard c) {
        this.cardnumber = c.getCardNumber();
        this.expirationMonth = c.getExpirationMonth();
        this.expirationYear = c.getExpirationYear();
        this.cardholder = c.getCardholder();
        this.type = c.getType();
    }

    public CreditcardDTO() {
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
