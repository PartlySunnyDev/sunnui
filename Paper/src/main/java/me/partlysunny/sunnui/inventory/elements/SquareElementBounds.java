package me.partlysunny.sunnui.inventory.elements;

import com.google.common.collect.Streams;
import me.partlysunny.sunnui.inventory.element.ElementBounds;
import me.partlysunny.sunnui.util.Coord;

import java.util.ArrayList;
import java.util.List;

public class SquareElementBounds implements ElementBounds {

    private final Coord coord;
    private final int width;
    private final int height;

    public SquareElementBounds(Coord coord, int width, int height) {
        this.coord = coord;
        this.width = width;
        this.height = height;
    }

    public SquareElementBounds(Coord coord) {
        this(coord, 1, 1);
    }

    @Override
    public List<Coord> getBoundContents() {
        List<Coord> coords = new ArrayList<>();
        for (int x = coord.getX(); x < coord.getX() + width; x++) {
            for (int y = coord.getY(); y < coord.getY() + height; y++) {
                coords.add(new Coord(x, y));
            }
        }
        return coords;
    }

    @Override
    public boolean contains(Coord coord) {
        return coord.getX() >= this.coord.getX() && coord.getX() < this.coord.getX() + width && coord.getY() >= this.coord.getY() && coord.getY() < this.coord.getY() + height;
    }
}
