package ds.example.beepz.Models;

import java.util.List;

public class Services {
    private List<ServicesItem> data;

    public Services(List<ServicesItem> data) {
        this.data = data;
    }

    public List<ServicesItem> getData() {
        return data;
    }

    public void setData(List<ServicesItem> data) {
        this.data = data;
    }
}
