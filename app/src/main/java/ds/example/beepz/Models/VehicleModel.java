package ds.example.beepz.Models;

public class VehicleModel {
    private String modelName, details;

    public VehicleModel() {}

    public VehicleModel(String modelName, String details) {
        this.modelName = modelName;
        this.details = details;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
