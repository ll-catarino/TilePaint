package org.academiadecodigo.anderdogs.tilePaint.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile {
    private Position position;
    private Rectangle rect;

    public Tile(Position position) {
        this.position = position;
        this.rect = null;
    }

    public Position getPosition() {
        return position;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void paint() {
        rect.setColor(Color.BLACK);
    }

    public void clear() {
        rect.setColor(Color.WHITE);
    }

    @Override
    public String toString() {
        return rect.getColor().equals(Color.BLACK) ? "1" : "0";
    }
}
