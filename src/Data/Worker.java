package Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Worker implements Comparable<Worker>{
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final double salary; //Значение поля должно быть больше 0
    private final java.util.Date startDate; //Поле не может быть null
    private final Position position; //Поле может быть null
    private final Status status; //Поле не может быть null
    private final Person person; //Поле может быть null

    public Worker(long id, String name, java.time.LocalDateTime creationDate, double salary, java.util.Date startDate, Position position, Status status, Person person) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.salary = salary;
        this. startDate = startDate;
        this.position = position;
        this.status = status;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    @Override
    public int compareTo(Worker o) {
        return Double.compare(o.getSalary(), this.getSalary());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", position=" + position +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}
