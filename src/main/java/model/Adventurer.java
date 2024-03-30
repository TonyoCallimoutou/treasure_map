package main.java.model;

public class Adventurer {
    private String name;
    private Position position;
    private Orientation orientation;
    private Movement[] movements;
    private int treasures;

    public Adventurer(String name, Position position, Orientation orientation, Movement[] movements) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.movements = movements;
        this.treasures = 0;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Movement[] getMovements() {
        return movements;
    }

    public String getStringMovements() {
        StringBuilder strMovements = new StringBuilder();
        for (Movement movement : movements) {
            strMovements.append(movement.getLetter());
        }
        return strMovements.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setMovements(Movement[] movements) {
        this.movements = movements;
    }

    public int getTreasures() {
        return treasures;
    }

    public void addTreasure() {
        this.treasures++;
    }
}
