package sweeper;

import java.util.ArrayList;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    void start() {
        bombMap = new Matrix(Box.zero);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void fixBombsCount() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }

    }

    private void placeBomb() {
        while (true) {
            Coord coord = Ranges.getRandomCoord();
            if ((Box.bomb == bombMap.get(coord)) || (!(Ranges.getAllCoords().contains(coord))))
                continue;
            bombMap.set(coord, Box.bomb);
            incNumAroundBomb(coord);
            break;
        }
    }

    private void incNumAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord))
            if (Box.bomb != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).getNextNumBox());
    }

    int getTotalBombs() {
        return totalBombs;
    }
}
