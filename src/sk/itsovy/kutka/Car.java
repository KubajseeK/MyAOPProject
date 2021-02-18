package sk.itsovy.kutka;

public class Car {

    private String model;
    private String gasType;

    public Car(String model, String gasType) {
        this.model = model;
        this.gasType = gasType;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", gasType='" + gasType + '\'' +
                '}';
    }
}
