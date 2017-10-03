package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.Point;

public class Field {

    private final int fieldSize;

    private final Figure[][] field;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int minX() { return 0; }

    public int minY() { return 0; }

    public int maxX() { return field.length-1; }

    public int maxY() { return field[0].length-1; }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(int x, int y) throws InvalidPointException {
        return getFigure(new Point(x, y));
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(int x, int y, Figure figure) throws InvalidPointException {
        setFigure(new Point(x, y), figure);
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point) {
        return minX() <= point.x && point.x <= maxX()
                && minY() <= point.y && point.y <= maxY();
    }

}
