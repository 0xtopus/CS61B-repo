import java.util.ArrayList;
import java.util.List;

/**
 * From lab6, 2019
 * link: https://sp19.datastructur.es/materials/lab/lab6/lab6
 * skeleton code link:https://github.com/Berkeley-CS61B/skeleton-sp19/blob/master/lab6/UnionFind.java
  */
public class UnionFind {

    private List<Integer> uf;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        uf = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) {
            uf.add(-1);
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex > uf.size()) {
            throw new RuntimeException("vertex is not a valid index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return uf.get(v1);
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        int v1RootPos = find(v1);
        int v2RootPos = find(v2);
        if (v1RootPos == v2RootPos) {
            return;
        } else if (-uf.get(v2RootPos) >= -uf.get(v1RootPos)) {
            // if the size of v2's set is bigger or equal to v1's set size
            uf.set(v2RootPos, uf.get(v2RootPos) + uf.get(v1RootPos)); // increase v2 set size
            uf.set(v1RootPos, v2RootPos);   // v1's set root points to v2's set root
        } else {
            uf.set(v1RootPos, uf.get(v2RootPos) + uf.get(v1RootPos)); // increase v1 set size
            uf.set(v2RootPos, v1RootPos);   // v2's set root points to v1's set root
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        validate(vertex);
        int temp = parent(vertex);
        int rootPos = vertex;
        while(temp >= 0) {
            rootPos = temp;
            temp = parent(temp);
        }
        // Path-compression
        while (vertex != rootPos) {
            uf.set(vertex, rootPos);
            vertex = parent(vertex);
        }
        return rootPos;
    }

}