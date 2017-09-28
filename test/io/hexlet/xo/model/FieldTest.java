package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        Field field = new Field();
        field.setFigure(0, 0, Figure.X);
        field.setFigure(1, 1, Figure.O);

        assertEquals(Figure.X, field.getFigure(0, 0));
        assertEquals(Figure.O, field.getFigure(1, 1));
        assertEquals(null, field.getFigure(1, 2));
    }

    @Test
    public void setFigureWithPoint() throws Exception {
        Field field = new Field();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);

        assertEquals(Figure.X, field.getFigure(new Point(0, 0)));
        assertEquals(Figure.O, field.getFigure(new Point(1, 1)));
        assertEquals(null, field.getFigure(new Point(1, 2)));
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e) {}

    }
}