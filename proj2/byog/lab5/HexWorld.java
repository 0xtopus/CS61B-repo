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
    public static int size = 4;
    private static final int WIDTH = 11 * size - 6; // 3 * ((size - 1) * 2 + size) + 2 * size
    private static final int HEIGHT = 10 * size;

    /**
     * Draw the whole huge hexagon made by 19 basic small hexagons
     * @param TETile[][]
     * @param size
     */
    public static void addHexagon(TETile[][] hexaTile, int size) {
        
        // drawSmallHexagon(hexaTile, size);

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
        // Print the top half hexagon
        for (int i = start; i < start + end; i++) {
            drawOneLine(
                startRow, 
                startColumn, 
                size, 
                hexaTile, 
                Tileset.FLOWER
            );
            startRow++;
            startColumn--;
            size += 2;
        }
        // Print the bottom half hexagon
        for (int i = start; i < start + end; i++) {
            size -= 2;
            startColumn++;
            drawOneLine(
                startRow, 
                startColumn, 
                size, 
                hexaTile, 
                Tileset.WALL
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

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH + 4, HEIGHT + 4);

        TETile[][] hexagonTiles = new TETile[WIDTH + 4][HEIGHT + 4];
        for (int x = 0; x < WIDTH + 4; x += 1) {
            for (int y = 0; y < HEIGHT + 4; y += 1) {
                hexagonTiles[x][y] = Tileset.FLOOR;
            }
        }
        // addHexagon(hexagonTiles, 6);
        int row = 5;
        int column = 10;
        hexagonTiles[column][row] = Tileset.GRASS;
        drawSmallHexagon(row, column, hexagonTiles, 2);
        // drawSmallHexagon(row+12, column-7, hexagonTiles, 3);
        drawSmallHexagon(row+5, column+10, hexagonTiles, 4);


        // draws the world to the screen
        ter.renderFrame(hexagonTiles);
    }
}
