package me.partlysunny.sunnui.inventory.element;

import me.partlysunny.sunnui.util.Coord;

import java.util.List;

/**
 * Represents the boundaries of a {@link InventoryElement}.
 */
public interface ElementBounds {

    /**
     * Used to get all coordinates
     * @return a list of all coordinates that are contained within the bounds.
     */
    List<Coord> getBoundContents();

    /**
     * Checks if the given coordinate is contained within the bounds.
     * This exists to allow for more efficient checking of coordinates for things like AABB
     * @param coord the coordinate to check
     * @return true if the coordinate is contained within the bounds, false otherwise.
     */
    boolean contains(Coord coord);
}
