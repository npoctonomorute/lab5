package Data;

public class Location {
    private Double x; //Поле не может быть null
    private double y;
    private Double z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(Double x) {
        this.x = x;
    }
}
