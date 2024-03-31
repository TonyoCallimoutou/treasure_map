package main.java.model;

public class Mountain extends ItemTreasureMap {

    public Mountain(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "M - " + getPosition().getX() + " - " + getPosition().getY();
    }
}
