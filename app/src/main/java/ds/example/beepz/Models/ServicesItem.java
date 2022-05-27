package ds.example.beepz.Models;

public class ServicesItem {
    private int orderId, customerId;
    private Category category;
    private Car car;
    private String bookingDate;
    private OrderTrack orderTrack;

    public ServicesItem() {
    }

    public ServicesItem(int orderId, int customerId, Category category, Car car, String bookingDate, OrderTrack orderTrack) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.category = category;
        this.car = car;
        this.bookingDate = bookingDate;
        this.orderTrack = orderTrack;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public OrderTrack getOrderTrack() {
        return orderTrack;
    }

    public void setOrderTrack(OrderTrack orderTrack) {
        this.orderTrack = orderTrack;
    }
}
