public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected String registrationNumber;
    protected Person owner;

    /** constructor. */
    public Vehicle(String brand, String model, String registrationNumber, Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    protected abstract String getInfo();

    public void transferOwnership(Person newOwner) {
        this.setOwner(newOwner);
    }

}
