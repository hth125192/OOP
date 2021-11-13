import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    /** constructor. */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /** compareTo. */
    public int compareTo(Person person) {
        if (this.equals(person)) {
            return Integer.compare(this.age, person.getAge());
        } else {
            return name.compareTo(person.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

}
 