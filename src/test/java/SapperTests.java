import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import sweeper.*;

import java.util.ArrayList;

public class SapperTests {
    @Test
    public void setSizeAllCoordsTest() {
        ArrayList<Coord> getIfOddSide = new ArrayList<>();
        getIfOddSide.add(new Coord(0, 4));
        getIfOddSide.add(new Coord(1, 4));
        getIfOddSide.add(new Coord(2, 4));
        getIfOddSide.add(new Coord(3, 4));
        getIfOddSide.add(new Coord(4, 4));
        getIfOddSide.add(new Coord(5, 4));
        getIfOddSide.add(new Coord(6, 4));
        getIfOddSide.add(new Coord(7, 4));
        getIfOddSide.add(new Coord(8, 4));
        getIfOddSide.add(new Coord(1, 3));
        getIfOddSide.add(new Coord(1, 5));
        getIfOddSide.add(new Coord(2, 3));
        getIfOddSide.add(new Coord(2, 5));
        getIfOddSide.add(new Coord(3, 3));
        getIfOddSide.add(new Coord(3, 5));
        getIfOddSide.add(new Coord(4, 3));
        getIfOddSide.add(new Coord(4, 5));
        getIfOddSide.add(new Coord(5, 3));
        getIfOddSide.add(new Coord(5, 5));
        getIfOddSide.add(new Coord(6, 3));
        getIfOddSide.add(new Coord(6, 5));
        getIfOddSide.add(new Coord(7, 3));
        getIfOddSide.add(new Coord(7, 5));
        getIfOddSide.add(new Coord(8, 3));
        getIfOddSide.add(new Coord(8, 5));
        getIfOddSide.add(new Coord(1, 2));
        getIfOddSide.add(new Coord(1, 6));
        getIfOddSide.add(new Coord(2, 2));
        getIfOddSide.add(new Coord(2, 6));
        getIfOddSide.add(new Coord(3, 2));
        getIfOddSide.add(new Coord(3, 6));
        getIfOddSide.add(new Coord(4, 2));
        getIfOddSide.add(new Coord(4, 6));
        getIfOddSide.add(new Coord(5, 2));
        getIfOddSide.add(new Coord(5, 6));
        getIfOddSide.add(new Coord(6, 2));
        getIfOddSide.add(new Coord(6, 6));
        getIfOddSide.add(new Coord(7, 2));
        getIfOddSide.add(new Coord(7, 6));
        getIfOddSide.add(new Coord(2, 1));
        getIfOddSide.add(new Coord(2, 7));
        getIfOddSide.add(new Coord(3, 1));
        getIfOddSide.add(new Coord(3, 7));
        getIfOddSide.add(new Coord(4, 1));
        getIfOddSide.add(new Coord(4, 7));
        getIfOddSide.add(new Coord(5, 1));
        getIfOddSide.add(new Coord(5, 7));
        getIfOddSide.add(new Coord(6, 1));
        getIfOddSide.add(new Coord(6, 7));
        getIfOddSide.add(new Coord(7, 1));
        getIfOddSide.add(new Coord(7, 7));
        getIfOddSide.add(new Coord(2, 0));
        getIfOddSide.add(new Coord(2, 8));
        getIfOddSide.add(new Coord(3, 0));
        getIfOddSide.add(new Coord(3, 8));
        getIfOddSide.add(new Coord(4, 0));
        getIfOddSide.add(new Coord(4, 8));
        getIfOddSide.add(new Coord(5, 0));
        getIfOddSide.add(new Coord(5, 8));
        getIfOddSide.add(new Coord(6, 0));
        getIfOddSide.add(new Coord(6, 8));
        Ranges.setSize(new Coord(9, 9));
        ArrayList<Coord> ans = Ranges.getAllCoords();
        Assertions.assertEquals(getIfOddSide, ans);

        ArrayList<Coord> getIfEvenSide = new ArrayList<>();
        getIfEvenSide.add(new Coord(0, 3));
        getIfEvenSide.add(new Coord(1, 3));
        getIfEvenSide.add(new Coord(2, 3));
        getIfEvenSide.add(new Coord(3, 3));
        getIfEvenSide.add(new Coord(4, 3));
        getIfEvenSide.add(new Coord(5, 3));
        getIfEvenSide.add(new Coord(6, 3));
        getIfEvenSide.add(new Coord(0, 2));
        getIfEvenSide.add(new Coord(0, 4));
        getIfEvenSide.add(new Coord(1, 2));
        getIfEvenSide.add(new Coord(1, 4));
        getIfEvenSide.add(new Coord(2, 2));
        getIfEvenSide.add(new Coord(2, 4));
        getIfEvenSide.add(new Coord(3, 2));
        getIfEvenSide.add(new Coord(3, 4));
        getIfEvenSide.add(new Coord(4, 2));
        getIfEvenSide.add(new Coord(4, 4));
        getIfEvenSide.add(new Coord(5, 2));
        getIfEvenSide.add(new Coord(5, 4));
        getIfEvenSide.add(new Coord(1, 1));
        getIfEvenSide.add(new Coord(1, 5));
        getIfEvenSide.add(new Coord(2, 1));
        getIfEvenSide.add(new Coord(2, 5));
        getIfEvenSide.add(new Coord(3, 1));
        getIfEvenSide.add(new Coord(3, 5));
        getIfEvenSide.add(new Coord(4, 1));
        getIfEvenSide.add(new Coord(4, 5));
        getIfEvenSide.add(new Coord(5, 1));
        getIfEvenSide.add(new Coord(5, 5));
        getIfEvenSide.add(new Coord(1, 0));
        getIfEvenSide.add(new Coord(1, 6));
        getIfEvenSide.add(new Coord(2, 0));
        getIfEvenSide.add(new Coord(2, 6));
        getIfEvenSide.add(new Coord(3, 0));
        getIfEvenSide.add(new Coord(3, 6));
        getIfEvenSide.add(new Coord(4, 0));
        getIfEvenSide.add(new Coord(4, 6));
        Ranges.setSize(new Coord(7, 7));
        Assertions.assertEquals(getIfEvenSide, Ranges.getAllCoords());
    }

    @Test
    public void getCoordsAroundTest() {
        Ranges.setSize(new Coord(9, 9));
        ArrayList<Coord> forOneCoord = new ArrayList<>();
        forOneCoord.add(new Coord(3, 0));
        forOneCoord.add(new Coord(3, 1));
        forOneCoord.add(new Coord(2, 1));
        Assertions.assertEquals(forOneCoord, Ranges.getCoordsAround(new Coord(2, 0)));

        forOneCoord.clear();
        forOneCoord.add(new Coord(2, 2));
        forOneCoord.add(new Coord(2, 3));
        forOneCoord.add(new Coord(2, 4));
        forOneCoord.add(new Coord(3, 2));
        forOneCoord.add(new Coord(3, 4));
        forOneCoord.add(new Coord(4, 3));
        Assertions.assertEquals(forOneCoord, Ranges.getCoordsAround(new Coord(3, 3)));

        forOneCoord.clear();
        forOneCoord.add(new Coord(3, 1));
        forOneCoord.add(new Coord(3, 2));
        forOneCoord.add(new Coord(3, 3));
        forOneCoord.add(new Coord(2, 1));
        forOneCoord.add(new Coord(2, 3));
        forOneCoord.add(new Coord(1, 2));
        Assertions.assertEquals(forOneCoord, Ranges.getCoordsAround(new Coord(2, 2)));
    }

    @Test
    public void placeBombTest() {
        Game game = new Game(7, 7, 0);
        game.start();
        Bomb bomb = game.getBomb();
        Assertions.assertEquals(Box.zero, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(2, 1));
        Assertions.assertEquals(Box.num1, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(1, 2));
        Assertions.assertEquals(Box.num2, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(2, 3));
        Assertions.assertEquals(Box.num3, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(3, 3));
        Assertions.assertEquals(Box.num4, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(3, 2));
        Assertions.assertEquals(Box.num5, bomb.get(new Coord(2, 2)));
        bomb.placeBombHere(new Coord(3, 1));
        Assertions.assertEquals(Box.num6, bomb.get(new Coord(2, 2)));
    }

    @Test
    public void checkWinnerTest() {
        Game game = new Game(11, 11, 5);
        game.start();
        Bomb bomb = game.getBomb();
        Flag flag = game.getFlag();
        for (Coord coord : Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.bomb)
                flag.toggleFlagedToBox(coord);
            else
                game.openBox(coord);
        }
        game.checkWinner();
        Assertions.assertEquals(GameState.winner, game.getState());
    }
}
