import java.awt.image.Raster;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {

    private static final boolean LEFT_SIDE = true;
    private static final boolean RIGHT_SIDE = false;
    private static final boolean UPPER_SIDE = true;
    private static final boolean LOWER_SIDE = false;

    public Rasterer() {
        // YOUR CODE HERE
    }

    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     *
     *     The grid of images must obey the following properties, where image in the
     *     grid is referred to as a "tile".
     *     <ul>
     *         <li>The tiles collected must cover the most longitudinal distance per pixel
     *         (LonDPP) possible, while still covering less than or equal to the amount of
     *         longitudinal distance per pixel in the query box for the user viewport size. </li>
     *         <li>Contains all tiles that intersect the query bounding box that fulfill the
     *         above condition.</li>
     *         <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     *     </ul>
     *
     * @param params Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     *
     * @return A map of results for the front end as specified: <br>
     * "render_grid"   : String[][], the files to display. <br>
     * "raster_ul_lon" : Number, the bounding upper left longitude of the rastered image. <br>
     * "raster_ul_lat" : Number, the bounding upper left latitude of the rastered image. <br>
     * "raster_lr_lon" : Number, the bounding lower right longitude of the rastered image. <br>
     * "raster_lr_lat" : Number, the bounding lower right latitude of the rastered image. <br>
     * "depth"         : Number, the depth of the nodes of the rastered image <br>
     * "query_success" : Boolean, whether the query was able to successfully complete; don't
     *                    forget to set this to true on success! <br>
     */
    public Map<String, Object> getMapRaster(Map<String, Double> params) {
        System.out.println(params);
        Map<String, Object> results = new HashMap<>();
        // System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in "
        //                   + "your browser.");

        // validate params
        results.put("query_success", paramsValidator(params));

        // calculate the depth
        int depth = depthCalculator(params.get("lrlon"), params.get("ullon"), params.get("w"));
        results.put("depth", depth);

        // calculate the raster_ul_lon and the raster_lr_lon
        double tileLength = (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / Math.pow(2, depth);

        int ullonOffsetValue = rasterLongitudeCalculator(params.get("ullon"), tileLength, LEFT_SIDE);
        double raster_ul_lon = MapServer.ROOT_ULLON + ullonOffsetValue * tileLength;
        results.put("raster_ul_lon", raster_ul_lon);

        int lrlonOffsetValue = rasterLongitudeCalculator(params.get("lrlon"), tileLength, RIGHT_SIDE);;
        double raster_lr_lon = MapServer.ROOT_ULLON + lrlonOffsetValue * tileLength;
        results.put("raster_lr_lon", raster_lr_lon);

        // calculate the raster_ul_lat and the raster_lr_lat
        double tileWidth = (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / Math.pow(2, depth);

        int ullatOffsetValue = rasterLatitudeCalculator(params.get("ullat"), tileWidth, UPPER_SIDE);
        double raster_ul_lat = MapServer.ROOT_ULLAT - ullatOffsetValue * tileWidth;
        results.put("raster_ul_lat", raster_ul_lat);

        int lrlatOffsetValue = rasterLatitudeCalculator(params.get("lrlat"), tileWidth, LOWER_SIDE);
        double raster_lr_lat = MapServer.ROOT_ULLAT - lrlatOffsetValue * tileWidth;
        results.put("raster_lr_lat", raster_lr_lat);

        // find all tiles needed to render
        String[][] render_grid = new String[lrlatOffsetValue - ullatOffsetValue][];
        for (int i = ullatOffsetValue; i < lrlatOffsetValue; i++) {
            render_grid[i - ullatOffsetValue] = new String[lrlonOffsetValue - ullonOffsetValue];
            for (int j = ullonOffsetValue; j < lrlonOffsetValue; j++) {
                render_grid[i - ullatOffsetValue][j - ullonOffsetValue] = "d" + depth +"_x" + j + "_y" + i +".png";
            }
        }
        results.put("render_grid", render_grid);
        return results;
    }

    /**
     * Calculate the depth
     */
    private static int depthCalculator(double lrlon, double ullon, double width) {
        double queryBoxLonDPP = (lrlon - ullon) / width;
        double leftLon = MapServer.ROOT_ULLON;
        int depth = 0;
        double tileLonDPP = (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / MapServer.TILE_SIZE;
        while(queryBoxLonDPP < tileLonDPP && depth < 7) {
            depth++;
            leftLon = (MapServer.ROOT_LRLON + leftLon) / 2;
            tileLonDPP = (MapServer.ROOT_LRLON - leftLon) / MapServer.TILE_SIZE;
        }
        return  depth;
    }

    /**
    * Calculate the closest raster longitude
    */
    private static int rasterLongitudeCalculator(double queryLon, double tileLength, boolean SIDE) {
        // if outbound
        /*if (queryLon < MapServer.ROOT_ULLON) {
            return MapServer.ROOT_ULLON;
        }
        if (queryLon > MapServer.ROOT_LRLON) {
            return MapServer.ROOT_LRLON;
        }*/
        double closestLonBeforeQueryLon = MapServer.ROOT_ULLON;
        int offsetValue = 0;
        while (closestLonBeforeQueryLon < queryLon) {
            // Note that the longitudes we use here are negative numbers,
            // from MapServer.ROOT_ULLON to MapServer.ROOT_LRLON
            closestLonBeforeQueryLon += tileLength;  // move side length of 1 tile from left to right
            offsetValue++;
        }
        if (SIDE) {
            // System.out.println("return: " + (MapServer.ROOT_ULLON + (offsetValue - 1) * tileLength));
            // return closestLonBeforeQueryLon - tileLength;
            return offsetValue - 1;     // left bounding longitude
        } else {
            // System.out.println("return: " + (MapServer.ROOT_ULLON + (offsetValue) * tileLength));
            // return closestLonBeforeQueryLon;
            return offsetValue;     // right bounding longitude
        }
    }

    /**
     * Calculate the closest raster latitude
     */
    private static int rasterLatitudeCalculator(double queryLat, double tileWidth, boolean SIDE) {
        // if outbound
/*        if (queryLat > MapServer.ROOT_ULLAT) {
            return MapServer.ROOT_ULLAT;
        }
        if (queryLat < MapServer.ROOT_LRLAT) {
            return MapServer.ROOT_LRLAT;
        }*/
//        double tileWidth = (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / Math.pow(2, depth);
        double closestLatBeforeQueryLat = MapServer.ROOT_ULLAT;
        int offsetValue = 0;
        while (closestLatBeforeQueryLat > queryLat) {
            closestLatBeforeQueryLat -= tileWidth;
            offsetValue++;
        }
        if (SIDE) {
            // System.out.println(offsetValue);
            // System.out.println("return: "+ (MapServer.ROOT_ULLAT - (offsetValue - 1) * tileWidth));
            // return closestLatBeforeQueryLat + tileWidth;
            return offsetValue - 1;     // upper bounding latitude
        } else {
            // System.out.println(offsetValue);
            // System.out.println("return: "+ (MapServer.ROOT_ULLAT - offsetValue * tileWidth));
            // return closestLatBeforeQueryLat;
            return offsetValue;     // lower bounding latitude
        }
    }


    public static void main(String[] args) {
        double lrlon = -122.24053369025242;
        double ullon = -122.24163047377972;
        double ullat = 37.87655856892288;
        double lrlat = 37.87548268822065;
        double width = 892.0;

//        ullat=37.88708748276975;
//        lrlat=37.848731523430196;
//        lrlon=-122.20908713544797;
//        ullon=-122.3027284165759;
//        width = 305.0;

//        lrlon = -122.2104604264636;
//        ullon = -122.30410170759153;
//        width = 1091.0;
//        ullat = 37.870213571328854;
//        lrlat = 37.8318576119893;

        lrlat=37.858292608;
        lrlon=-122.222751327;
        ullat=37.877266154;
        ullon=-122.239956628;
        width=613.0;

        // Test depth(set depthCalculator to static before test)
        int d = depthCalculator(lrlon, ullon, width);   // d = 7
        System.out.println(d);

        // Note that tileLength is positive(tileLength > 0)
        double tileLength = (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / Math.pow(2, d);

        int ullonOffsetValue = rasterLongitudeCalculator(ullon, tileLength, LEFT_SIDE);
        System.out.println("ullonOffsetValue: " + ullonOffsetValue);
        System.out.println(MapServer.ROOT_ULLON + ullonOffsetValue * tileLength);     // raster_ul_lon=-122.24212646484375

        int lrlonOffsetValue = rasterLongitudeCalculator(lrlon, tileLength, RIGHT_SIDE);
        System.out.println("lrlonOffsetValue: " + lrlonOffsetValue);
        System.out.println(MapServer.ROOT_ULLON + lrlonOffsetValue * tileLength);     // raster_lr_lon=-122.24006652832031

        double tileWidth = (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / Math.pow(2, d);
        int ullatOffsetValue = rasterLatitudeCalculator(ullat, tileWidth, UPPER_SIDE);
        System.out.println("ullatOffsetValue: " + ullatOffsetValue);
        System.out.println(MapServer.ROOT_ULLAT - ullatOffsetValue * tileWidth);     // 37.87701580361881

        int lrlatOffsetValue = rasterLatitudeCalculator(lrlat, tileWidth, LOWER_SIDE);
        System.out.println("lrlatOffsetValue: " + lrlatOffsetValue);
        System.out.println(MapServer.ROOT_ULLAT - lrlatOffsetValue * tileWidth);     // 37.87538940251607

        String[][] render_grid = new String[lrlatOffsetValue - ullatOffsetValue][];
        for (int i = ullatOffsetValue; i < lrlatOffsetValue; i++) {
            render_grid[i - ullatOffsetValue] = new String[lrlonOffsetValue - ullonOffsetValue];
            for (int j = ullonOffsetValue; j < lrlonOffsetValue; j++) {
                render_grid[i - ullatOffsetValue][j - ullonOffsetValue] = "d" + d +"_x" + j + "_y" + i +".png";
            }
        }
    }

    /*
    * Validate the input params are inbound
    */
    private boolean paramsValidator(Map<String, Double> params) {
        double lrlon = params.get("lrlon");
        double ullon = params.get("ullon");
        double ullat = params.get("ullat");
        double lrlat = params.get("lrlat");
        if (
                lrlon > ullon
                && lrlat < ullat
                && lrlon <= MapServer.ROOT_LRLON
                && ullon >= MapServer.ROOT_ULLON
                && lrlat >= MapServer.ROOT_LRLAT
                && ullat <= MapServer.ROOT_ULLAT
        ) {
            return true;
        }
        return false;
    }
}
