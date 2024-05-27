package lab_6.common.Classes.dto;

import lab_6.common.Classes.Person;
import lab_6.common.Classes.Position;
import lab_6.common.Classes.Status;

import java.io.Serializable;
import java.util.Date;

public class WorkerDTO implements Serializable {
    private final static long serialVersionID = 22335L;
    private long id;
    private String name;
    private double salary;
    private Date startDate;
    private Position position;
    private Status status;
    private Person person;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
