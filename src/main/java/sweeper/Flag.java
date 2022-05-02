package sweeper;

class Flag {

    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.closed);
        countOfClosedBoxes = Ranges.getAllCoords().size();
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.opened);
        countOfClosedBoxes--;
    }

    void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.flaged);
    }

    void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case flaged:
                setClosedToBox(coord);
                break;
            case closed:
                setFlagedToBox(coord);
                break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.closed);
    }

    int getCountClosedBoxes() {
        return countOfClosedBoxes;
    }


    void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.bombed);
    }

    void setOpenedToCloseBomb(Coord coord) {
        if (flagMap.get(coord) == Box.closed)
            flagMap.set(coord, Box.opened);
    }

    void setNoBombToFlagedSafe(Coord coord) {
        if (flagMap.get(coord) == Box.flaged)
            flagMap.set(coord, Box.nobomb);
    }

    int getCountOfFlagedBoxesAround(Coord coord) {
        int count = 0;
        for (Coord around : Ranges.getCoordsAround(coord))
            if (flagMap.get(around) == Box.flaged)
                count++;
        return count;
    }
}