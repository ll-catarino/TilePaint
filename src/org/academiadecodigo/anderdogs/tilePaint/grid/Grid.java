package org.academiadecodigo.anderdogs.tilePaint.grid;

import java.util.HashMap;

public class Grid {
    private HashMap<Position, Tile> tiles;
    private int maxX;
    private int maxY;
    private Tile cursor;


    public Grid(int maxX, int maxY) {
        tiles = new HashMap<>();
        this.maxX = maxX;
        this.maxY = maxY;
        cursor = new Tile(new Position(0,0));

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                Position p = new Position(x, y);
                tiles.put(p, new Tile(p));
            }
        }
    }


    public Tile getTile(Position position) {
        return tiles.get(position);
    }

    public Tile getCursor() {
        return cursor;
    }

    public void moveCursor(Direction direction) {
        int x = cursor.getPosition().getX();
        int y = cursor.getPosition().getY();

        switch (direction) {
            case UP:
                y = y - 1 < 0 ? 0 : y - 1;
                break;
            case DOWN:
                y = y + 1 > maxY-1 ? maxY-1 : y + 1;
                break;
            case LEFT:
                x = x - 1 < 0 ? 0 : x - 1;
                break;
            case RIGHT:
                x = x + 1 > maxX-1 ? maxX-1 : x + 1;
                break;
        }

        cursor.getPosition().setX(x);
        cursor.getPosition().setY(y);
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
