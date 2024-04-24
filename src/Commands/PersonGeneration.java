package Commands;

import Data.Color;
import Data.Country;
import Data.Location;
import Data.Person;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonGeneration{
    /**
     * @param arg
     * @return
     */
    public Person execute(String arg) {
        String[] parts = arg.split(" ", 7);

        String birthdayStr = parts[0];
        DateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday2;
        try {
            birthday2 = formatter2.parse(birthdayStr);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }

        String colorCode = parts[1];
        Color color = Color.values()[Integer.parseInt(colorCode)];

        String countryCode = parts[2];
        Country country = Country.values()[Integer.parseInt(countryCode)];

        Double x = Double.parseDouble(parts[3]);
        Double y = Double.parseDouble(parts[4]);
        Double z = Double.parseDouble(parts[5]);
        String locName = parts[6];

        Person person = new Person(birthday2,
                color,
                country,
                new Location(x, y, z, locName));

        return person;
    }

}
