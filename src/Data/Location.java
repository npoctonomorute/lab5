package Data;

public class Location {
    private final Double x; //Поле не может быть null
    private final Double y;
    private final Double z; //Поле не может быть null
    private final String name; //Поле не может быть null

    public Location(Double x, double y, Double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
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

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
    public boolean equals (Object other) {
        Location loc = (Location) other;
        if (loc.x.equals(this.x) && loc.y.equals(this.y) && loc.z.equals(this.z) && loc.name.equals(this.name)) {
            return true;
        }else{
            return false;
        }
    }
}
