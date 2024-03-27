package main.java.model;

public class Adventurer {
    private String name;
    private Position position;
    private String orientation;
    private String movements;

    public Adventurer(String name, Position position, String orientation, String movements) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.movements = movements;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getMovements() {
        return movements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }
}
