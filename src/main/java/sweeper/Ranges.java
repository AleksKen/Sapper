package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;
    private static Random random = new Random();

    public static void setSize(Coord _size) {
        size = _size;
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord(x, y));
                allCoords.remove(new Coord(0,6));
                allCoords.remove(new Coord(0,5));
                allCoords.remove(new Coord(0,1));
                allCoords.remove(new Coord(0,0));
                allCoords.remove(new Coord(5, 0));
                allCoords.remove(new Coord(6, 0));
                allCoords.remove(new Coord(6, 1));
                allCoords.remove(new Coord(6, 2));
                allCoords.remove(new Coord(6,4));
                allCoords.remove(new Coord(5,6));
                allCoords.remove(new Coord(6,5));
                allCoords.remove(new Coord(6,6));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    static boolean inRange(Coord coord) {
        return ((coord.x >= 0) && (coord.x < size.x) && (coord.y >= 0) && (coord.y < size.y) &&
                (allCoords.contains(coord)));
    }

    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }

    static ArrayList<Coord> getCoordsAround(Coord coord) {
        ArrayList<Coord> list = new ArrayList<Coord>();
        ArrayList<Coord> assum = new ArrayList<Coord>();
        if (coord.y % 2 == 1){
            assum.add(new Coord(coord.x-1, coord.y-1));
            assum.add(new Coord(coord.x-1, coord.y));
            assum.add(new Coord(coord.x-1, coord.y+1));
            assum.add(new Coord(coord.x, coord.y-1));
            assum.add(new Coord(coord.x, coord.y+1));
            assum.add(new Coord(coord.x+1, coord.y));
        }
        else{
            assum.add(new Coord(coord.x+1, coord.y-1));
            assum.add(new Coord(coord.x+1, coord.y));
            assum.add(new Coord(coord.x+1, coord.y+1));
            assum.add(new Coord(coord.x, coord.y-1));
            assum.add(new Coord(coord.x, coord.y+1));
            assum.add(new Coord(coord.x-1, coord.y));
        }

        for (Coord coord1: assum)
            if (inRange(coord1))
                list.add(coord1);
        return list;
    }
}
