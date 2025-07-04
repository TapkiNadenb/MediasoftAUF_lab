import java.util.Objects;

public class Car {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;

    public Car(String vin, String model, String manufacturer,
               int year, int mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }
    public String getModel() {
        return model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getYear() {
        return year;
    }
    public int getMileage() {
        return mileage;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car other = (Car) o;
        return Objects.equals(vin, other.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return "Машина{" +
                "VIN='" + vin + '\'' +
                ", Изготоитель:'" + manufacturer + '\'' +
                ", Модель:'" + model + '\'' +
                ", Год: " + year +
                ", пробег: " + mileage + " km" +
                ", Цена:" + price +
                '}';

    }
}