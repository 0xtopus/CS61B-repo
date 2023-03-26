package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        int s = maze.xyTo1D(1, 1);
        findCycleByDFS(s, 0);
    }

    // Helper methods go here
    private void findCycleByDFS(int v, int parent) {
        marked[v] = true;        
        for (int neighbor : maze.adj(v)) {
            if (!marked[neighbor]) {
                marked[neighbor] = true;
                announce();        
                findCycleByDFS(neighbor, v);
                break;
            } else if (neighbor != parent) {
                edgeTo[neighbor] = v;
                edgeTo[v] = neighbor;
                announce();        
                edgeTheCycle(v, neighbor);
                return;
            }
        }
    }

    private void edgeTheCycle(int v, int end) {
        if (v == end) {
            return;
        }        
        for (int n : maze.adj(v)) {
            if (marked[n] && edgeTo[n] != v) {
                edgeTo[n] = v;
                announce();
                edgeTheCycle(n, end);
                break;
            }
        }

    }
}

