package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    public static int size = 7;
    // The width and height of the whole huge hexagon
    private static final int WIDTH = 11 * size - 6; // 3 * longest line + 2 * shortest line: 3 * ((size - 1) * 2 + size) + 2 * size
    private static final int HEIGHT = 10 * size;    // 5 * size is the height of the huge hexagon

    private static final long SEED = 123456;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Draw the whole huge hexagon made by 19 basic small hexagons.
     * @param TETile[][]
     * @param size
     */
    public static void addHexagon(TETile[][] hexaTile, int size) {
        int currRow = 2 * size + 1;
        int currColumn = size + 1; 
        // the right side start column 
        // WIDTH + 1 is the right margin of the huge hexagon, and 2 * (size - 1) locates to the bottom left of the small hexagon
        int reverseCurrColumn = WIDTH + 1 - 2 * (size - 1); 
        // column interval between each start point 
        int columnInterval = 2 * (size - 1) + 1;
        // draw the huge hexagon except its middle column
        for (int num = 3; num < 5; num++) {
            pileTheHexagons(currRow, currColumn, hexaTile, size, num);
            pileTheHexagons(currRow, reverseCurrColumn, hexaTile, size, num);
            currRow = currRow - size;
            currColumn = currColumn + columnInterval;
            reverseCurrColumn = reverseCurrColumn - columnInterval;
        }
        // draw the middle column 
        pileTheHexagons(currRow, currColumn, hexaTile, size, 5);
    }

    /**
     * Pile a column of hexagons from bottom to top with the given number in given position.
     * @param startRow
     * @param startColumn
     * @param hexaTile
     * @param size
     * @param num
     */
    private static void pileTheHexagons(int startRow, int startColumn, TETile[][] hexaTile, int size, int num) {
        int currRow = startRow;
        int currColumn = startColumn;
        for (int i = 0; i < num; i++) {
            drawSmallHexagon(
                currRow,
                currColumn,
                hexaTile,
                size
            );
            currRow = currRow + 2 * size;
        }
    }

    /**
     * Draw a single Hexagon, starting from left bottom of the hexagon.
     * @param startRow
     * @param startColumn
     * @param hexaTile
     * @param size
     */
    public static void drawSmallHexagon(int startRow, int startColumn, TETile[][] hexaTile, int size) {
        int end = size;
        int start = startRow;
        TETile tileStyle = randomTile();
        // Print the top half small hexagon
        for (int i = start; i < start + end; i++) {
            drawOneLine(
                startRow,
                startColumn,
                size,
                hexaTile,
                tileStyle
            );
            startRow++;
            startColumn--;
            size += 2;
        }
        // Print the bottom half small hexagon
        for (int i = start; i < start + end; i++) {
            size -= 2;
            startColumn++;
            drawOneLine(
                startRow,
                startColumn,
                size,
                hexaTile,
                tileStyle
            );
            startRow++;
        }
    }

    /**
     * Draw a single line.
     * @param startRow
     * @param startColumn
     * @param num
     * @param hexaTiles
     * @param tileType
     */
    public static void drawOneLine(
            int startRow,
            int startColumn,
            int num,
            TETile[][] hexaTiles,
            TETile tileType
        ) {
        for (int i = 0; i < num; i++) {
            hexaTiles[i + startColumn][startRow] = tileType;
        }
    }

    /**
     * Picks a RANDOM tile.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(9);
        switch (tileNum) {
            case 0:
                return Tileset.WALL;
            case 1:
                return Tileset.FLOWER;
            case 2:
                return Tileset.MOUNTAIN;
            case 3:
                return Tileset.UNLOCKED_DOOR;
            case 4:
                return Tileset.LOCKED_DOOR;
            case 5:
                return Tileset.SAND;
            case 6:
                return Tileset.TREE;
            case 7:
                return Tileset.GRASS;
            case 8:
                return Tileset.WATER;
            default:
                return Tileset.WALL;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH + 4, HEIGHT + 4);
        // the world is 4 digits bigger than the huge hexagon
        TETile[][] hexagonTiles = new TETile[WIDTH + 4][HEIGHT + 4];

        // fill the background as FLOOR
        for (int x = 0; x < WIDTH + 4; x += 1) {
            for (int y = 0; y < HEIGHT + 4; y += 1) {
                hexagonTiles[x][y] = Tileset.FLOOR;
            }
        }
        
        // create the huge hexagon
        addHexagon(hexagonTiles, size);
        
        // test position
        /*         
        int row = 5;
        int column = WIDTH + 1 - 2*(size-1);
        hexagonTiles[column][row] = Tileset.PLAYER;  
        */
        
        // draws the world to the screen
        ter.renderFrame(hexagonTiles);
    }
}
