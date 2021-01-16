package dto;

public class ReservationDTO {
    private int amountOfNights;
    private int pricePrNight;
    private String startDate;

    public ReservationDTO(int amountOfNights, int pricePrNight, String startDate) {
        this.amountOfNights = amountOfNights;
        this.pricePrNight = pricePrNight;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    
}
