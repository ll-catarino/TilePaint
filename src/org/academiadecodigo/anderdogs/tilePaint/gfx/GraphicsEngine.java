package org.academiadecodigo.anderdogs.tilePaint.gfx;

import org.academiadecodigo.anderdogs.tilePaint.grid.Grid;
import org.academiadecodigo.anderdogs.tilePaint.grid.Position;
import org.academiadecodigo.anderdogs.tilePaint.grid.Tile;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GraphicsEngine {
    static final int PADDING = 10;
    static final int CELL_SIZE = 20;
    private Grid grid;

    public GraphicsEngine(Grid grid) {
        this.grid = grid;
        drawGrid();
        grid.getCursor().setRect(new Rectangle(convert(grid.getCursor().getPosition().getX()), convert(grid.getCursor().getPosition().getY()), CELL_SIZE, CELL_SIZE));
        grid.getCursor().getRect().setColor(Color.CYAN);
        drawCursor();
    }



    public void drawCursor() {
        grid.getCursor().getRect().translate(-grid.getCursor().getRect().getX(),-grid.getCursor().getRect().getY());// translate to 0
        grid.getCursor().getRect().translate(convert(grid.getCursor().getPosition().getX()), convert(grid.getCursor().getPosition().getY()));// translate to pos

        drawTile(grid.getCursor());
    }

    public void drawTile(Tile tile) {
        tile.getRect().fill();
    }

    public void drawGrid() {
        for (int x = 0; x < grid.getMaxX(); x++) {
            for (int y = 0; y < grid.getMaxY(); y++) {
                Tile tile = grid.getTile(new Position(x, y));
                tile.setRect(new Rectangle(convert(x), convert(y), CELL_SIZE, CELL_SIZE));
                tile.getRect().setColor(Color.WHITE);
                drawTile(tile);
            }
        }
    }

    private int convert(int x) {
        return PADDING + x * CELL_SIZE;
    }

}
