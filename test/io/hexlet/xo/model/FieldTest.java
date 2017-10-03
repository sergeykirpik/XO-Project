package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        Field field = new Field(3);
        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        Field field = new Field(3);
        field.setFigure(0, 0, Figure.X);
        field.setFigure(1, 1, Figure.O);

        assertEquals(Figure.X, field.getFigure(0, 0));
        assertEquals(Figure.O, field.getFigure(1, 1));
        assertEquals(null, field.getFigure(1, 2));
    }

    @Test
    public void setFigureWithPoint() throws Exception {
        Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);

        assertEquals(Figure.X, field.getFigure(new Point(0, 0)));
        assertEquals(Figure.O, field.getFigure(new Point(1, 1)));
        assertEquals(null, field.getFigure(new Point(1, 2)));
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testSetFigureForMinCoordinates() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX(), field.minY());
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
    }

    @Test
    public void testSetFigureForXLessThanMinCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX()-1, field.minY());
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testSetFigureForYLessThanMinCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX(), field.minY()-1);
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testSetFigureForMaxCoordinates() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX(), field.maxY());
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(inputPoint, inputFigure);
        } catch (InvalidPointException e) {
            fail();
        }

    }

    @Test
    public void testSetFigureForXGreaterThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX()+1, field.maxY());
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testSetFigureForYGreaterThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX(), field.maxY()+1);
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureForMinCoordinates() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX(), field.minY());

        try {
            field.getFigure(inputPoint);
        } catch (InvalidPointException e) {
            fail();
        }

    }

    @Test
    public void testGetFigureForXLessThanMinCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX()-1, field.minY());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureForYLessThanMinCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.minX(), field.minY()-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureForMaxCoordinates() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX(), field.maxY());

        try {
            field.getFigure(inputPoint);
        } catch (InvalidPointException e) {
            fail();
        }

    }

    @Test
    public void testGetFigureForXGreaterThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX()+1, field.maxY());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureForYGreaterThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.maxX(), field.maxY()+1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
        }

    }


}