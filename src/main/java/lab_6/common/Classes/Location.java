package lab_6.common.Classes;

import java.io.Serializable;

public class Location implements Serializable {
    private Double x;
    private Double y;
    private Double z;
    private String name;

    public Location(Double x, Double y, Double z, String locationName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = locationName;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
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

    public void setY(Double y) {
        this.y = y;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object other) {
        Location loc = (Location) other;
        if (loc.x.equals(this.x) && loc.y.equals(this.y) && loc.z.equals(this.z) && loc.name.equals(this.name)) {
            return true;
        } else {
            return false;
        }
    }
}
