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
        System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in "
                           + "your browser.");

        // validate params are valid
        results.put("query_success", paramsValidator(params));
        // calculate the depth to use
        int depth = depthCalculator(params.get("lrlon"), params.get("ullon"), params.get("w"));
        results.put("depth", depth);
        // calculate the raster_ul_lon and the raster_lr_lon
        double raster_ul_lon = rasterLongitudeCalculator(params.get("ullon"), depth, LEFT_SIDE);
        double raster_lr_lon = rasterLongitudeCalculator(params.get("lrlon"), depth, RIGHT_SIDE);
        results.put("raster_lr_lon", raster_lr_lon);
        results.put("raster_ul_lon", raster_ul_lon);

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
    private static double rasterLongitudeCalculator(double queryLon, double depth, boolean SIDE) {
        // if outbound
        if (queryLon < MapServer.ROOT_ULLON) {
            return MapServer.ROOT_ULLON;
        }
        if (queryLon > MapServer.ROOT_LRLON) {
            return MapServer.ROOT_LRLON;
        }
        double lonBeforeQueryLon = MapServer.ROOT_ULLON;
        // Note that sideLengthPerTile is positive(sideLengthPerTile > 0)
        double sideLengthPerTile = (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / Math.pow(2, depth);
        while (lonBeforeQueryLon < queryLon) {
            // Note that the longitudes we use here are negative numbers,
            // from MapServer.ROOT_ULLON to MapServer.ROOT_LRLON
            lonBeforeQueryLon += sideLengthPerTile;  // move side length of 1 tile from left to right
        }
        if (SIDE) {
            return lonBeforeQueryLon - sideLengthPerTile; // left bounding longitude
        } else {
            return lonBeforeQueryLon;   // right bounding longitude
        }
    }

    /**
     * Calculate the closest raster latitude
     */
    private static double rasterLatitudeCalculator(double queryLat, double depth, boolean SIDE) {
        // if outbound
        if (queryLat > MapServer.ROOT_ULLAT) {
            return MapServer.ROOT_ULLAT;
        }
        if (queryLat < MapServer.ROOT_LRLAT) {
            return MapServer.ROOT_LRLAT;
        }
        double sideLengthPerTile = (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / Math.pow(2, depth);
        double latBeforeQueryLat = MapServer.ROOT_ULLAT;
        while (latBeforeQueryLat > queryLat) {
            latBeforeQueryLat -= sideLengthPerTile;
        }
        if (SIDE) {
            return latBeforeQueryLat + sideLengthPerTile; // upper bounding latitude
        } else {
            return latBeforeQueryLat;   // lower bounding latitude
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

        // Test depth(set depthCalculator to static before test)
        int d = depthCalculator(lrlon, ullon, width);
        System.out.println(d);
        System.out.println(rasterLongitudeCalculator(lrlon, d, RIGHT_SIDE));
        System.out.println(rasterLongitudeCalculator(ullon, d, LEFT_SIDE));
        System.out.println(rasterLatitudeCalculator(ullat, d, UPPER_SIDE));     // 37.87701580361881
        System.out.println(rasterLatitudeCalculator(lrlat, d, LOWER_SIDE));     // 37.87538940251607
    }

    // TODO: validate/*
    //  You can also imagine that the user might drag the query box to a location
    //  that is completely outside of the root longitude/latitudes.
    //  In this case, there is nothing to raster, raster_ul_lon, raster_ul_lat, etc. are arbitrary,
    //  and you should set query_success: false. If the server receives a query box that doesn’t make any sense,
    //  eg. ullon, ullat is located to the right of lrlon, lrlat,
    //  you should also ensure query_success is set to false.
    //  */
    private boolean paramsValidator(Map<String, Double> params) {
        return false;
    }
}
