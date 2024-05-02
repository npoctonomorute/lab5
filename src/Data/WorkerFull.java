package Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Full info about worker
 */
public class WorkerFull implements Comparable<Worker>{
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final java.time.LocalDateTime creationDate;//Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final double salary;
    private final java.util.Date startDate;
    private final Position position;
    private final Status status;
    private final java.util.Date birthday;
    private final Color hairColor;
    private final Country nation;
    private final double x;
    private final double y;
    private final double z;
    private final String locationName;

    public WorkerFull(long id, String name, LocalDateTime creationDate, double salary, Date startDate, Position position, Status status, Date birthday, Color hairColor, Country nation, double x, double y, double z, String locationName) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nation = nation;
        this.x = x;
        this.y = y;
        this.z = z;
        this.locationName = locationName;
    }

    @Override
    public int compareTo(Worker o) {
        return Double.compare(o.getSalary(), this.getSalary());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Position getPosition() {
        return position;
    }

    public Status getStatus() {
        return status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNation() {
        return nation;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getLocationName() {
        return locationName;
    }


}
