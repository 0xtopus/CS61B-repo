import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

/**
 * Graph for storing all of the intersection (vertex) and road (edge) information.
 * Uses your GraphBuildingHandler to convert the XML files into a graph. Your
 * code must include the vertices, adjacent, distance, closest, lat, and lon
 * methods. You'll also need to include instance variables and methods for
 * modifying the graph (e.g. addNode and addEdge).
 *
 * @author Alan Yao, Josh Hug
 */
public class GraphDB {
    /* mapGraph to contain the Nodes */
    private final Map<Long, Vertex> mapGraph = new HashMap<>();

    /** Your instance variables for storing the graph. You should consider
     * creating helper classes, e.g. Node, Edge, etc. */

    /**
     * Example constructor shows how to create and start an XML parser.
     * You do not need to modify this constructor, but you're welcome to do so.
     * @param dbPath Path to the XML file to be parsed.
     */
    public GraphDB(String dbPath) {
        try {
            File inputFile = new File(dbPath);
            FileInputStream inputStream = new FileInputStream(inputFile);
            // GZIPInputStream stream = new GZIPInputStream(inputStream);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            GraphBuildingHandler gbh = new GraphBuildingHandler(this);
            saxParser.parse(inputStream, gbh);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        clean();
    }

    static class Vertex {
        private final long id;
        private final double lat;
        private final double lon;
        private final List<Long> neighborNodes;

        public Vertex(long id, double longitude, double latitude) {
            this.id = id;
            this.lat = latitude;
            this.lon = longitude;
            neighborNodes = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Vertex that = (Vertex) obj;
            return Objects.equals(this.id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id);
        }
    }

    /**
     * Add vertex with no neighbor to the mapGraph
     *
     * @param id Input Vertex id
     * @param lon Input Vertex longitude
     * @param lat Input Vertex latitude
     */
    void addVertex(long id, double lon, double lat) {
        this.mapGraph.put(id, new Vertex(id, lon, lat));
    }

    /**
     * Add edge to a node.
     *
     * @param id id of the node
     * @param neighborId id of the neighbor to be connected
     */
    void addEdge(Long id, Long neighborId) {
        Vertex node = this.mapGraph.get(id);
        Vertex neighborNode = this.mapGraph.get(neighborId);
        if (node != null && neighborNode != null) {
            node.neighborNodes.add(neighborId);
            neighborNode.neighborNodes.add(id);
            // System.out.println(id + " connected to " + neighborId);
        }
    }

    /**
     * Connect nodes in the nodeStack
     *
     * @param nodeStack nodes to connect with each other
     */
    void addWays(Stack<Long> nodeStack) {
        if (nodeStack.empty()) {
            return;
        }
        long id = nodeStack.pop();
        while (!nodeStack.empty()) {
            addEdge(id, nodeStack.peek());
            id = nodeStack.pop();
        }
    }

    /**
     * Helper to process strings into their "cleaned" form, ignoring punctuation and capitalization.
     * @param s Input string.
     * @return Cleaned string.
     */
    static String cleanString(String s) {
        return s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    /**
     *  Remove nodes with no connections from the graph.
     *  While this does not guarantee that any two nodes in the remaining graph are connected,
     *  we can reasonably assume this since typically roads are connected.
     */
    private void clean() {
        Set<Long> lonelyVertices = new HashSet<>();
        for (Long id : this.mapGraph.keySet()) {
            Vertex vertex = this.mapGraph.get(id);
            if (vertex.neighborNodes.isEmpty()) {
                lonelyVertices.add(id);
            }
        }
        for (long id : lonelyVertices) {
            mapGraph.remove(id);
        }
    }

    /**
     * Returns an iterable of all vertex IDs in the graph.
     * @return An iterable of id's of all vertices in the graph.
     */
    Iterable<Long> vertices() {
        //YOUR CODE HERE, this currently returns only an empty list.
        return new ArrayList<Long>(mapGraph.keySet());
    }

    /**
     * Returns ids of all vertices adjacent to v.
     * @param v The id of the vertex we are looking adjacent to.
     * @return An iterable of the ids of the neighbors of v.
     */
    Iterable<Long> adjacent(long v) {
        return mapGraph.get(v).neighborNodes;
    }

    /**
     * Returns the great-circle distance between vertices v and w in miles.
     * Assumes the lon/lat methods are implemented properly.
     * <a href="https://www.movable-type.co.uk/scripts/latlong.html">Source</a>.
     * @param v The id of the first vertex.
     * @param w The id of the second vertex.
     * @return The great-circle distance between the two locations from the graph.
     */
    double distance(long v, long w) {
        return distance(lon(v), lat(v), lon(w), lat(w));
    }

    static double distance(double lonV, double latV, double lonW, double latW) {
        double phi1 = Math.toRadians(latV);
        double phi2 = Math.toRadians(latW);
        double dphi = Math.toRadians(latW - latV);
        double dlambda = Math.toRadians(lonW - lonV);

        double a = Math.sin(dphi / 2.0) * Math.sin(dphi / 2.0);
        a += Math.cos(phi1) * Math.cos(phi2) * Math.sin(dlambda / 2.0) * Math.sin(dlambda / 2.0);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 3963 * c;
    }

    /**
     * Returns the initial bearing (angle) between vertices v and w in degrees.
     * The initial bearing is the angle that, if followed in a straight line
     * along a great-circle arc from the starting point, would take you to the
     * end point.
     * Assumes the lon/lat methods are implemented properly.
     * <a href="https://www.movable-type.co.uk/scripts/latlong.html">Source</a>.
     * @param v The id of the first vertex.
     * @param w The id of the second vertex.
     * @return The initial bearing between the vertices.
     */
    double bearing(long v, long w) {
        return bearing(lon(v), lat(v), lon(w), lat(w));
    }

    static double bearing(double lonV, double latV, double lonW, double latW) {
        double phi1 = Math.toRadians(latV);
        double phi2 = Math.toRadians(latW);
        double lambda1 = Math.toRadians(lonV);
        double lambda2 = Math.toRadians(lonW);

        double y = Math.sin(lambda2 - lambda1) * Math.cos(phi2);
        double x = Math.cos(phi1) * Math.sin(phi2);
        x -= Math.sin(phi1) * Math.cos(phi2) * Math.cos(lambda2 - lambda1);
        return Math.toDegrees(Math.atan2(y, x));
    }

    /**
     * Returns the vertex closest to the given longitude and latitude.
     * @param lon The target longitude.
     * @param lat The target latitude.
     * @return The id of the node in the graph closest to the target.
     */
    long closest(double lon, double lat) {
        long closestVertexId = -1;
        double minDistance = Double.MAX_VALUE;
        for (long id : mapGraph.keySet()) {
            Vertex vertex = this.mapGraph.get(id);
            double currentDistance = distance(vertex.lon, vertex.lat, lon, lat);
            if (currentDistance <= minDistance) {
                minDistance = currentDistance;
                closestVertexId = id;
            }
        }
        /* if return -1, then there is no vertex in the Graph */
        return closestVertexId;
    }

    /**
     * Gets the longitude of a vertex.
     * @param v The id of the vertex.
     * @return The longitude of the vertex.
     */
    double lon(long v) {
        return mapGraph.get(v).lon;
    }

    /**
     * Gets the latitude of a vertex.
     * @param v The id of the vertex.
     * @return The latitude of the vertex.
     */
    double lat(long v) {
        return mapGraph.get(v).lat;
    }

    /**
     * Get vertex by the given id.
     *
     * @param id the id of vertex
     */
    Vertex vertexGetter(long id) {
        return this.mapGraph.get(id);
    }

}
