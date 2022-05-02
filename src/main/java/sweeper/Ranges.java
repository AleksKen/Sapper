package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;
    private static Random random = new Random();

    public static void setSize(Coord _size) {
        size = _size;
        int diag = size.x;
        int str = (size.x + 1) / 2;
        allCoords = new ArrayList<Coord>();

        for (int i = 0; i < diag; i++)
            allCoords.add(new Coord(i, str - 1));

        if (str % 2 == 0) {
            for (int i = 0; i < diag - 1; i++) {
                allCoords.add(new Coord(i, str - 2));
                allCoords.add(new Coord(i, str));
            }
            int curDiag = diag;
            int curStolb = str - 3;
            int curNum = str + 1;
            for (int i = 1; i < str / 2; i++) {

                for (int j = i; j < curDiag - 1; j++) {
                    allCoords.add(new Coord(j, curStolb));
                    allCoords.add(new Coord(j, curNum));
                }
                for (int j = i; j < curDiag - 2; j++) {
                    allCoords.add(new Coord(j, curStolb - 1));
                    allCoords.add(new Coord(j, curNum + 1));
                }
                curStolb -= 2;
                curNum += 2;
                curDiag--;
            }
        } else {
            int curDiag = diag;
            int curStolb = str - 2;
            int curNum = str;
            for (int i = 1; i <= (str - 1) / 2; i++) {
                for (int j = i; j < curDiag; j++) {
                    allCoords.add(new Coord(j, curStolb));
                    allCoords.add(new Coord(j, curNum));
                }
                for (int j = i; j < curDiag - 1; j++) {
                    allCoords.add(new Coord(j, curStolb - 1));
                    allCoords.add(new Coord(j, curNum + 1));
                }
                curStolb -= 2;
                curNum += 2;
                curDiag--;
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
        if (coord.y % 2 == 1) {
            assum.add(new Coord(coord.x - 1, coord.y - 1));
            assum.add(new Coord(coord.x - 1, coord.y));
            assum.add(new Coord(coord.x - 1, coord.y + 1));
            assum.add(new Coord(coord.x, coord.y - 1));
            assum.add(new Coord(coord.x, coord.y + 1));
            assum.add(new Coord(coord.x + 1, coord.y));
        } else {
            assum.add(new Coord(coord.x + 1, coord.y - 1));
            assum.add(new Coord(coord.x + 1, coord.y));
            assum.add(new Coord(coord.x + 1, coord.y + 1));
            assum.add(new Coord(coord.x, coord.y - 1));
            assum.add(new Coord(coord.x, coord.y + 1));
            assum.add(new Coord(coord.x - 1, coord.y));
        }

        for (Coord coord1 : assum)
            if (inRange(coord1))
                list.add(coord1);
        return list;
    }
}