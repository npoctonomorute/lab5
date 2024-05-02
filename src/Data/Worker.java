package Data;

import java.time.LocalDateTime;
import java.util.Date;

public class Worker implements Comparable<Worker>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final double salary; //Значение поля должно быть больше 0
    private final java.util.Date startDate; //Поле не может быть null
    private final Position position; //Поле может быть null
    private final Status status; //Поле не может быть null
    private final Person person; //Поле может быть null

    public Worker(long id, WorkerData workerData) {
        this.id = id;
        this.name = workerData.getName();
        this.creationDate = workerData.getCreationDate();
        this.salary = workerData.getSalary();
        this.startDate = workerData.getStartDate();
        this.position = workerData.getPosition();
        this.status = workerData.getStatus();
        this.person = workerData.getPerson();
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
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
