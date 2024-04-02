package org.treasure_map.utils;

import org.treasure_map.model.Position;

public class PositionUtils {

    public static boolean isPositionInBound(Position position, int x, int y) {
        if ((position.getX() >= 0 && position.getX() < x) &&
                position.getY() >= 0 && position.getY() < y) {
            return true;
        }
        throw new IllegalArgumentException("Position (" + position + ") is out of bounds");
    }
}
