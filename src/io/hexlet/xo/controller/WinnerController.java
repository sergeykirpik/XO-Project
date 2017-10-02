package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

public class WinnerController {

    public Figure getWinner(final Field field) {

        try {
            Figure[] figures;
            int x, y;

            for (x = 0; x < field.getSize(); x++) {
                figures = getFigures(field, new Point(x, 0),
                                       p -> new Point(p.x, p.y+1));
                if (test(figures)) return figures[0];
            }

            for (y = 0; y < field.getSize(); y++) {
                figures = getFigures(field, new Point(0, y),
                                       p -> new Point(p.x+1, p.y));
                if (test(figures)) return figures[0];
            }

            figures = getFigures(field, new Point(0, 0),
                                   p -> new Point(p.x+1, p.y+1));
            if (test(figures)) return figures[0];

            figures = getFigures(field, new Point(0, 2),
                                   p -> new Point(p.x+1, p.y-1));

            if (test(figures)) return figures[0];

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Figure[] getFigures(Field field, Point startPoint,
                                Function<Point, Point> changer)
            throws InvalidPointException {

        Figure[] result = new Figure[field.getSize()];
        Point p = startPoint;
        for (int i = 0; i < field.getSize(); i++) {
            result[i] = field.getFigure(p);
            p = changer.apply(p);
        }

        return result;
    }

    private boolean test(Figure[] figures) {
        if (       figures[0] != null
                && figures[0] == figures[1]
                && figures[0] == figures[2])
            return true;

        return false;
    }
}
