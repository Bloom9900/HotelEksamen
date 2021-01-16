package dto;

public class BookingDTO {
    private CustomerDTO cDTO;
    private HotelDTO hDTO;
    private CreditcardDTO creditDTO;
    private ReservationDTO rDTO;

    public BookingDTO(CustomerDTO cDTO, HotelDTO hDTO, CreditcardDTO creditDTO, ReservationDTO rDTO) {
        this.cDTO = cDTO;
        this.hDTO = hDTO;
        this.creditDTO = creditDTO;
        this.rDTO = rDTO;
    }

    public CustomerDTO getcDTO() {
        return cDTO;
    }

    public void setcDTO(CustomerDTO cDTO) {
        this.cDTO = cDTO;
    }

    public HotelDTO gethDTO() {
        return hDTO;
    }

    public void sethDTO(HotelDTO hDTO) {
        this.hDTO = hDTO;
    }

    public CreditcardDTO getCreditDTO() {
        return creditDTO;
    }

    public void setCreditDTO(CreditcardDTO creditDTO) {
        this.creditDTO = creditDTO;
    }
    
    
}
