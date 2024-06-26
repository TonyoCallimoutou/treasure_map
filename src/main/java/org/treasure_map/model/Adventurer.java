package org.treasure_map.model;

import org.treasure_map.constants.FileConst;
import org.treasure_map.enums.LetterItem;
import org.treasure_map.enums.Movement;
import org.treasure_map.enums.Orientation;
import org.treasure_map.utils.AdventurerUtils;

import java.util.List;

public class Adventurer extends ItemTreasureMap {
    private final String name;
    private Orientation orientation;
    private final List<Movement> movements;
    private int treasures;

    public Adventurer(String name, Position position, Orientation orientation, List<Movement> movements) {
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

    public List<Movement> getMovements() {
        return movements;
    }

    public String getStringMovements() {
        return AdventurerUtils.getStringMovements(movements);
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getTreasures() {
        return treasures;
    }

    public void addTreasure() {
        this.treasures++;
    }

    @Override
    public String toString() {
        return LetterItem.ADVENTURER.getLetter() + FileConst.SEPARATOR + name + FileConst.SEPARATOR + getPosition().getX() + FileConst.SEPARATOR + getPosition().getY() + FileConst.SEPARATOR + orientation.getLetter() + FileConst.SEPARATOR + treasures;
    }
}
