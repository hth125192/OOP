import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /** addVehicle. */
    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicleList.add(vehicle);
        }
    }

    /** removeVehicle. */
    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getRegistrationNumber() == registrationNumber) {
                vehicleList.remove(i);
                break;
            }
        }
    }

    /** getVehiclesInfo. */
    public String getVehiclesInfo() {
        if (vehicleList.size() == 0) {
            return this.getName() + " has no vehicle!";
        }
        String s = this.getName() + " has:\n";
        for (Vehicle vehicle : vehicleList) {
            s += "\n" + vehicle.getInfo();
        }
        return s;
    }

}
