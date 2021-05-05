package HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Seasons season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int days, Seasons season, Discount discount){
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }
    public double getPrice(){
        return this.days * this.pricePerDay *
                this.season.getMultiplier() *
                (1 - (this.discount.getDiscount() / 100.00));
    }
}
