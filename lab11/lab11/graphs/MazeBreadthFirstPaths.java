package lab11.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private List<Integer> fringe = new ArrayList<>();

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        t = maze.xyTo1D(targetX, targetY);
        s = maze.xyTo1D(sourceX, sourceY);
        distTo[s] = 0;
        edgeTo[s] = s;
        fringe.add(s);
        marked[s] = true;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        if (fringe.size() == 0) {
            return;
        }

        if (t == v) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        fringe.remove(0);
        for (int neighbor : maze.adj(v)) {
            if (!marked[neighbor]) {
                fringe.add(neighbor);
                marked[neighbor] = true;
                edgeTo[neighbor] = v;
                distTo[neighbor] = distTo[v] + 1; 
            }
        }
        announce();
        bfs(fringe.get(0));
    }


    @Override
    public void solve() {
        bfs(s);
    }
}

