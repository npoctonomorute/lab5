package Data;

import java.util.Date;

public class Person {
    private final java.util.Date birthday; //Поле не может быть null
    private final Color hairColor; //Поле может быть null
    private final Country nationality; //Поле не может быть null
    private final Location location; //Поле не может быть null

    public Person(Date birthday, Color hairColor, Country nationality, Location location) {
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
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

    @Override
    public String toString() {
        return "Person{" +
                "birthday=" + birthday +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }
}
