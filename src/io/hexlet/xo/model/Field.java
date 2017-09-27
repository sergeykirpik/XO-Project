package io.hexlet.xo.model;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(int x, int y) {
        return field[x][y];
    }

    public Figure getFigure(Point point) {
        return getFigure(point.x, point.y);
    }

    public void setFigure(int x, int y, Figure figure) {
        field[x][y] = figure;
    }

    public void setFigure(Point point, Figure figure) {
        setFigure(point.x, point.y, figure);
    }
}
