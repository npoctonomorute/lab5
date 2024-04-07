package Data;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -980, Поле не может быть null
    private double y; //Значение поля должно быть больше -415

    public Double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
