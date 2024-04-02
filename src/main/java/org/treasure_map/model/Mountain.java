package org.treasure_map.model;

import org.treasure_map.constants.FileConst;
import org.treasure_map.enums.LetterItem;

public class Mountain extends ItemTreasureMap {

    public Mountain(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return LetterItem.MOUNTAIN.getLetter() + FileConst.SEPARATOR + getPosition().getX() + FileConst.SEPARATOR + getPosition().getY();
    }
}
