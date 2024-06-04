package lab_6.common.Classes;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private Date birthday; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(Date birthday, Color color, Country country, Location location) {
        this.birthday = birthday;
        this.nationality = country;
        this.hairColor = color;
        this.location = location;
    }


    public Date getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthday=" + birthday +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    public boolean equals(Object other) {
        Person person = (Person) other;
        if (person.birthday.equals(this.birthday) && person.hairColor.equals(this.hairColor) && person.nationality.equals(this.nationality) && person.location.equals(this.location)) {
            return true;
        } else {
            return false;
        }
    }
}
