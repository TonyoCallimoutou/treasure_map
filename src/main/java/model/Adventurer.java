package main.java.model;

public class Adventurer extends ItemTreasureMap {
    private String name;
    private Orientation orientation;
    private Movement[] movements;
    private int treasures;

    public Adventurer(String name, Position position, Orientation orientation, Movement[] movements) {
        super(position);
        this.name = name;
        this.orientation = orientation;
        this.movements = movements;
        this.treasures = 0;
    }

    public String getName() {
        return name;
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
