package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {

        try {
            Figure f1, f2, f3;
            int x, y;

            for (x = 0; x < field.getSize(); x++) {
                f1 = field.getFigure(new Point(x, 0));
                f2 = field.getFigure(new Point(x, 1));
                f3 = field.getFigure(new Point(x, 2));

                if (f1 == f2 && f1 == f3) return f1;
            }

            for (y = 0; y < field.getSize(); y++) {
                f1 = field.getFigure(new Point(0, y));
                f2 = field.getFigure(new Point(1, y));
                f3 = field.getFigure(new Point(2, y));

                if (f1 == f2 && f1 == f3) return f1;
            }

            f1 = field.getFigure(new Point(0, 0));
            f2 = field.getFigure(new Point(1, 1));
            f3 = field.getFigure(new Point(2, 2));

            if (f1 == f2 && f1 == f3) return f1;

            f1 = field.getFigure(new Point(0, 2));
            f2 = field.getFigure(new Point(1, 1));
            f3 = field.getFigure(new Point(2, 0));

            if (f1 == f2 && f1 == f3) return f1;

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }
}
