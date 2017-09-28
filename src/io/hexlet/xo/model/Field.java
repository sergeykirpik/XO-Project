package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    static final int MIN_COORDINATE = 0;

    static final int MAX_COORDINATE = FIELD_SIZE - 1;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
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

    public void setFigure(int x, int y, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        setFigure(new Point(x, y), figure);
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= MAX_COORDINATE;
    }
}
