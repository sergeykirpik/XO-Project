package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void getWinnerHorizontalXO() throws Exception {
        testHorizontal(Figure.X);
        testHorizontal(Figure.O);
    }

    @Test
    public void getWinnerVerticalXO() throws Exception {
        testVertical(Figure.X);
        testVertical(Figure.O);
    }

    @Test
    public void getWinnerDiagonalXO() throws Exception {
        testDiagonal(Figure.X);
        testDiagonal(Figure.O);
    }

    @Test
    public void getWinnerNullExpected() throws Exception {
        Field field;
        Figure winner;

        field = new Field(3);
        winner = new WinnerController(3, field).getWinner();
        assertNull(winner);

        field = new Field(3);
        field.setFigure(0, 0, Figure.X);
        field.setFigure(1, 0, Figure.O);
        field.setFigure(2, 0, Figure.X);
        winner = new WinnerController(3, field).getWinner();
        assertNull(winner);
    }

    private void testHorizontal(Figure expectedWinner) throws Exception {

        Field field;
        Figure winner;

        field = new Field(3);
        field.setFigure(0, 0, expectedWinner);
        field.setFigure(0, 1, expectedWinner);
        field.setFigure(0, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);

        field = new Field(3);
        field.setFigure(1, 0, expectedWinner);
        field.setFigure(1, 1, expectedWinner);
        field.setFigure(1, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);

        field = new Field(3);
        field.setFigure(2, 0, expectedWinner);
        field.setFigure(2, 1, expectedWinner);
        field.setFigure(2, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);
    }

    private void testVertical(Figure expectedWinner) throws Exception {

        Field field;
        Figure winner;

        field = new Field(3);
        field.setFigure(0, 0, expectedWinner);
        field.setFigure(1, 0, expectedWinner);
        field.setFigure(2, 0, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);

        field = new Field(3);
        field.setFigure(0, 1, expectedWinner);
        field.setFigure(1, 1, expectedWinner);
        field.setFigure(2, 1, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);

        field = new Field(3);
        field.setFigure(0, 2, expectedWinner);
        field.setFigure(1, 2, expectedWinner);
        field.setFigure(2, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);
    }

    private void testDiagonal(Figure expectedWinner) throws Exception {

        Field field;
        Figure winner;

        field = new Field(3);
        field.setFigure(0, 0, expectedWinner);
        field.setFigure(1, 1, expectedWinner);
        field.setFigure(2, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);

        field = new Field(3);
        field.setFigure(2, 0, expectedWinner);
        field.setFigure(1, 1, expectedWinner);
        field.setFigure(0, 2, expectedWinner);

        winner = new WinnerController(3, field).getWinner();
        assertEquals(expectedWinner, winner);
    }

}