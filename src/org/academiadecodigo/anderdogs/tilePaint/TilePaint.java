package org.academiadecodigo.anderdogs.tilePaint;

import org.academiadecodigo.anderdogs.tilePaint.controls.Controls;
import org.academiadecodigo.anderdogs.tilePaint.gfx.GraphicsEngine;
import org.academiadecodigo.anderdogs.tilePaint.grid.Direction;
import org.academiadecodigo.anderdogs.tilePaint.grid.Grid;
import org.academiadecodigo.anderdogs.tilePaint.grid.Tile;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class TilePaint {
    private boolean exit;
    private Grid grid;
    private GraphicsEngine ge;

    public TilePaint(int x, int y) {
        exit = false;
        grid = new Grid(x, y);
        ge = new GraphicsEngine(grid);

        System.out.printf("grid size: %dx%d\n", x, y);


        new Controls(this);
    }

    public void start() {
        while (!exit) {
            System.out.printf("");
        }
        System.exit(0);
    }


    public void inputKey(KeyboardEvent key) {
        if (key.getKey() == 27)
            exit = true;


        switch (key.getKey()) {
            case KeyboardEvent.KEY_UP:
                grid.moveCursor(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                grid.moveCursor(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                grid.moveCursor(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                grid.moveCursor(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_K:
                grid.moveCursor(Direction.UP);
                break;
            case KeyboardEvent.KEY_J:
                grid.moveCursor(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_H:
                grid.moveCursor(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_L:
                grid.moveCursor(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:
                Tile t = grid.getTile(grid.getCursor().getPosition());
                t.paint();
                ge.drawTile(t);
                break;
        }
        ge.drawCursor();
    }

}
