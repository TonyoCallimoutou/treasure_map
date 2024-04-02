package main.java.model;

import main.java.constants.FileConst;
import main.java.enums.LetterItem;

public class Mountain extends ItemTreasureMap {

    public Mountain(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return LetterItem.MOUNTAIN.getLetter() + FileConst.SEPARATOR + getPosition().getX() + FileConst.SEPARATOR + getPosition().getY();
    }
}
