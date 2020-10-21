package org.academiadecodigo.anderdogs;

import org.academiadecodigo.anderdogs.tilePaint.TilePaint;

public class Main {
    private static final int STANDARD_SIZE = 20;
    public static void main(String[] args) {

        TilePaint paint;

        paint = args.length != 2 ? new TilePaint(STANDARD_SIZE, STANDARD_SIZE) : new TilePaint(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        paint.start();
    }
}
