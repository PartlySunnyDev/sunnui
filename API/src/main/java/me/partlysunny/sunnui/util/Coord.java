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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void add(Coord coord) {
        this.x += coord.getX();
        this.y += coord.getY();
    }

    public void subtract(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtract(Coord coord) {
        this.x -= coord.getX();
        this.y -= coord.getY();
    }

}
