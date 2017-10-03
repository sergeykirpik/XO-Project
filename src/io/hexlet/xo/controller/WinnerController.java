package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.Point;
import java.util.function.Function;

public class WinnerController {

    public Figure getWinner(final Field field) {

        class Tester {
            Figure test(
                    int startPointCount,
                    Point startPoint,
                    Function<Point, Point> startPointChanger,
                    Function<Point, Point> pointChanger)
                throws InvalidPointException {

                Point sPoint = startPoint;
                for (int i = 0; i < startPointCount; i++) {
                    Point point = new Point(sPoint);
                    Figure[] figures = getFigures(field, point, pointChanger);
                    if (testFigures(figures)) return figures[0];
                    sPoint = startPointChanger.apply(sPoint);
                }
                return null;
            }
        }

        try {
            Figure[] figures = new Figure[4];

            figures[0] = new Tester().test(3, new Point(0, 0),
                    p -> new Point(p.x+1,p.y),
                    p -> new Point(p.x, p.y+1));

            figures[1] = new Tester().test(3, new Point(0, 0),
                    p -> new Point(p.x,p.y+1),
                    p -> new Point(p.x+1, p.y));

            figures[2] = new Tester().test(1, new Point(0, 0),
                    p -> new Point(p.x,p.y),
                    p -> new Point(p.x+1, p.y+1));

            figures[3] = new Tester().test(1, new Point(0, 2),
                    p -> new Point(p.x,p.y),
                    p -> new Point(p.x+1, p.y-1));

            for (Figure f : figures) {
                if (f != null) return f;
            }

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

    private boolean testFigures(Figure[] figures) {
        if (       figures[0] != null
                && figures[0] == figures[1]
                && figures[0] == figures[2])
            return true;

        return false;
    }
}
