package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

class WinnerController {

    private final Field field;

    private final int countToWin;

    WinnerController(int countToWin, Field field) {
        this.countToWin = countToWin;
        this.field = field;
    }

    Figure getWinner() {

        try {
            // Horizontal scan
            for (int k = field.minY(); k <= field.maxY(); k++) {
                if (check(1, new Point(0, k), p -> new Point(p.x+1,p.y))){
                    return field.getFigure(0, k);
                }
            }

            // Vertical scan
            for (int k = field.minX(); k <= field.maxX(); k++) {
                if (check(1, new Point(k, 0), p -> new Point(p.x,p.y+1))){
                    return field.getFigure(k, 0);
                }
            }

            // Diagonal scan
            if (check(1, new Point(0, 0), p -> new Point(p.x+1, p.y+1))){
                return field.getFigure(0, 0);
            }

            if (check(1, new Point(0, field.maxY()), p -> new Point(p.x+1, p.y-1))){
                return field.getFigure(0, field.maxY());
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(int count, Point point, PointGenerator pointGenerator) {

        Figure currentFigure, nextFigure;
        Point nextPoint = pointGenerator.next(point);
        try {
            currentFigure = field.getFigure(point);
            nextFigure = field.getFigure(nextPoint);
            if (currentFigure == null) {
                return false;
            }
        } catch (InvalidPointException e) {
            return count >= countToWin;
        }

        if (currentFigure != nextFigure) {
            return count >= countToWin;
        }

        return check(count+1, nextPoint, pointGenerator);
    }

    private interface PointGenerator {
        Point next(final Point point);
    }
}
