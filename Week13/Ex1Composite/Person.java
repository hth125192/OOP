import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final String birthDate;
    private final String sex;
    private final String married;
    private final List<Person> children;

    public Person(String name, String birthDate, String sex, String married) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.married = married;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public String getMarried() {
        return married;
    }

    public List<Person> getChildren() {
        return children;
    }

    public String toString() {
        return "Name: " + name + ", Date of birth: " + birthDate + ", Sex: " + sex;
    }
}
