package entities;

public class Date {
    private int year;
    private int month;
    private int dayOfMonth;
    private int hour;
    private int minute;

    public Date(String startdate) {
        this.year = Integer.parseInt(startdate.substring(12,16));
        this.month = 
        this.dayOfMonth = Integer.parseInt(startdate.substring(9,10));
        this.hour = hour;
        this.minute = minute;
    }
    //Sat Jan 16 2021 22:41:17 GMT+0100 (Centraleuropæisk normaltid)

    
}
