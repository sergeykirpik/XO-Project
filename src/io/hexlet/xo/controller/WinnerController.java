package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class WinnerController {

    private final Field field;

    private final int countToWin;

    WinnerController(int countToWin, Field field) {
        this.countToWin = countToWin;
        this.field = field;
    }

    Figure getWinner() {

        try {
            List<Figure> figures = new ArrayList<>();
            int x, y, c;
            Figure f;

            // Horizontal scan
            for (x = field.minX(); x <= field.maxX(); x++) {
                figures.clear();
                for (y = field.minY(); y <= field.maxY(); y++) {
                    f = field.getFigure(new Point(x, y));
                    figures.add(f);
                }
                if (check(figures)) return figures.get(0);
            }

            // Vertical scan
            for (y = field.minY(); y <= field.maxY(); y++) {
                figures.clear();
                for (x = field.minX(); x <= field.maxX(); x++) {
                    f = field.getFigure(new Point(x, y));
                    figures.add(f);
                }
                if (check(figures)) return figures.get(0);
            }

            // Diagonal scan 1
            figures.clear();
            for (c = field.minX(); c <= field.maxX(); c++) {
                f = field.getFigure(new Point(c, c));
                figures.add(f);
            }
            if (check(figures)) return figures.get(0);

            // Diagonal scan 2
            figures.clear();
            for (c = field.minX(); c <= field.maxX(); c++) {
                f = field.getFigure(new Point(c, field.maxY()-c));
                figures.add(f);
            }
            if (check(figures)) return figures.get(0);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(List<Figure> figures) {
        if (figures.get(0) == null) {
            return false;
        }
        int count = 0;
        for (Figure f : figures) {
            if (f != figures.get(0)) {
                return false;
            }
            count++;
        }
        return count >= countToWin;
    }
}
