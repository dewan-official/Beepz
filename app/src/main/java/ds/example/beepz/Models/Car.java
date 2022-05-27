package ds.example.beepz.Models;

public class Car {
    private VehicleModel vehicleModel;
    private String vehicleNickName;

    public Car() {
    }


    public Car(VehicleModel vehicleModel, String vehicleNickName) {
        this.vehicleModel = vehicleModel;
        this.vehicleNickName = vehicleNickName;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNickName() {
        return vehicleNickName;
    }

    public void setVehicleNickName(String vehicleNickName) {
        this.vehicleNickName = vehicleNickName;
    }
}
