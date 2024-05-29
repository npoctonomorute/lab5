package lab_6.common.Classes;

import lab_6.common.Classes.dto.WorkerDTO;

import java.io.Serializable;
import java.util.Date;

public class Worker implements Comparable<Worker>, Serializable {
    //    private final static long serialVersionID = 22335L;
    private final long id;
    private final String name;
    private final Date creationDate;
    private final double salary;
    private final Date startDate;
    private final Position position;
    private final Status status;
    private final Person person;

    public Worker(long id, WorkerDTO dto) {
        this.id = id;
        this.name = dto.getName();
        this.creationDate = new Date();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.position = dto.getPosition();
        this.status = dto.getStatus();
        this.person = dto.getPerson();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
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
