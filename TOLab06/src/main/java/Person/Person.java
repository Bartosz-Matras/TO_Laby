package Person;


import java.util.Locale;

public class Person implements IPerson {
    private String name;
    private String surname;
    private double x;
    private double y;


    public Person() {
    }

    public Person(String name, String surname, double x, double y) {
        this.name = name;
        this.surname = surname;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String print(){
        return getName() + " " + getSurname() + " " + getX() + " " + getY();
    }

    @Override
    public void execute() {
        String firstNameLetter = this.getName().substring(0, 1).toUpperCase(Locale.ROOT);
        String firstSurnameLetter = this.getSurname().substring(0, 1).toUpperCase(Locale.ROOT);

        String nameL = this.getName().substring(1).toLowerCase(Locale.ROOT);
        String surnameL = this.getSurname().substring(1).toLowerCase(Locale.ROOT);


        this.setName(firstNameLetter + nameL);
        this.setSurname(firstSurnameLetter + surnameL);
    }

    @Override
    public String toString() {
        return "Person name: " + name + ", surname: " + surname + ", [x: " + x + ", y: " + y + "]";

    }
}
