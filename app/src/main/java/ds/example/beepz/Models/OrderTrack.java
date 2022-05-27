package ds.example.beepz.Models;

public class OrderTrack {
    private int orderTrackId, level;
    private String name, details, image;

    public OrderTrack() {
    }

    public OrderTrack(int orderTrackId, int level, String name, String details, String image) {
        this.orderTrackId = orderTrackId;
        this.level = level;
        this.name = name;
        this.details = details;
        this.image = image;
    }

    public int getOrderTrackId() {
        return orderTrackId;
    }

    public void setOrderTrackId(int orderTrackId) {
        this.orderTrackId = orderTrackId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
