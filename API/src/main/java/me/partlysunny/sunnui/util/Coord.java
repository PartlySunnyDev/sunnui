package me.partlysunny.sunnui.util;

public class Coord {

    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coord setX(int x) {
        this.x = x;
        return this;
    }

    public Coord setY(int y) {
        this.y = y;
        return this;
    }

    public Coord set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Coord add(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Coord add(Coord coord) {
        this.x += coord.getX();
        this.y += coord.getY();
        return this;
    }

    public Coord subtract(int x, int y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Coord subtract(Coord coord) {
        this.x -= coord.getX();
        this.y -= coord.getY();
        return this;
    }

    public Coord set(Coord coord) {
        this.x = coord.getX();
        this.y = coord.getY();
        return this;
    }

    public Coord clone() {
        return new Coord(x, y);
    }

    public static Coord from(int slot, int width) {
        return new Coord(slot % width, slot / width);
    }

    public static Coord from(int slot) {
        return from(slot, 9);
    }

    public static int toSlot(Coord coord, int width) {
        return coord.y * width + coord.x;
    }

    public static int toSlot(Coord coord) {
        return toSlot(coord, 9);
    }
}
