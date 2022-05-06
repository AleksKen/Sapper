package sweeper;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Game {
    private final Bomb bomb;
    private final Flag flag;
    private GameState state;
    private ZonedDateTime now;

    public GameState getState() {
        return state;
    }

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Flag getFlag() {
        return flag;
    }

    public void start() {
        now = ZonedDateTime.now();
        bomb.start();
        flag.start();
        state = GameState.played;
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.opened)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void pressLeftButton(Coord coord) {
        if (gameOver())
            return;
        openBox(coord);
        checkWinner();
    }

    public void checkWinner() {
        if (state == GameState.played)
            if (flag.getCountClosedBoxes() == bomb.getTotalBombs())
                state = GameState.winner;
    }

    public void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case opened:
                setOpenedToClosedBoxesAroundNumber(coord);
                return;
            case flaged:
                return;
            case closed:
                switch (bomb.get(coord)) {
                    case zero:
                        openBoxesAround(coord);
                        return;
                    case bomb:
                        openBombs(coord);
                        return;
                    default:
                        flag.setOpenedToBox(coord);
                        return;
                }
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
        if (bomb.get(coord) != Box.bomb)
            if (flag.getCountOfFlagedBoxesAround(coord) == bomb.get(coord).getNum())
                for (Coord around : Ranges.getCoordsAround(coord))
                    if (flag.get(around) == Box.closed)
                        openBox(around);
    }

    private void openBombs(Coord bombed) {
        state = GameState.bombed;
        flag.setBombedToBox(bombed);
        for (Coord coord : Ranges.getAllCoords())
            if (bomb.get(coord) == Box.bomb)
                flag.setOpenedToCloseBomb(coord);
            else
                flag.setNoBombToFlagedSafe(coord);
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getCoordsAround(coord))
            openBox(around);
    }

    public void pressRightBotton(Coord coord) {
        if (gameOver())
            return;
        flag.toggleFlagedToBox(coord);
    }

    private boolean gameOver() {
        if (state == GameState.played)
            return false;
        if (state == GameState.winner) {
            long second = now.until(ZonedDateTime.now(), ChronoUnit.SECONDS);
            TreeMap<Long, String> top10Old = new TreeMap<>();
            top10Old.put(second, " - количество секунд (количество бомб - " +
                    bomb.getTotalBombs() + " длина стороны - " +
                    (Ranges.getSize().x + 1) / 2 + " )");
            try (BufferedReader reader = new BufferedReader(new FileReader("leaderBoard"))) {
                String line;
                while (((line = reader.readLine()) != null) && (!(line.isEmpty()))) {
                    String[] spl = line.split(" ");
                    top10Old.put(Long.parseLong(spl[0]), line.substring(spl[0].length()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (top10Old.size() > 10)
                top10Old.remove(top10Old.lastKey());
            try (PrintWriter writer = new PrintWriter("leaderBoard")) {
                top10Old.forEach((k, v) -> writer.println(k + v));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        start();
        return true;
    }
}