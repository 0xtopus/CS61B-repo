package hw4.puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.MinPQ;

public class Solver {
    private final int moves;
    private final List<WorldState> sol = new ArrayList<>();
    private final Map<Node, Integer> totalMoves = new HashMap<>();

    private class Node {
        WorldState worldState;
        Node parentNode;
        int moves;

        public Node(WorldState ws, Node pNode, int moves) {
            worldState = ws;
            parentNode = pNode;
            this.moves = moves;
        }
    }

    // Defining a custom comparator for searchNodes order
    Comparator<Node> distanceComparator = new Comparator<Node>() {
        @Override
        public int compare(Node n1, Node n2) {
            if (totalMoves.get(n1) == null) {
                totalMoves.put(n1, n1.moves + n1.worldState.estimatedDistanceToGoal());
            }
            if (totalMoves.get(n2) == null) {
                totalMoves.put(n2, n2.moves + n2.worldState.estimatedDistanceToGoal());
            }
            return totalMoves.get(n1) - totalMoves.get(n2);
        }
    };

    public Solver(WorldState initial) {
        /* create a priority queue of search nodes */
        final MinPQ<Node> searchNodes = new MinPQ<>(1, distanceComparator);
        Node firstNode = new Node(initial, null, 0);
        /* insert an “initial search node” into the priority queue */
        searchNodes.insert(firstNode);
        /* Return the total moves to solve the problem */
        moves = solverHelper(searchNodes);
    }

    private int solverHelper(MinPQ<Node> searchNodes) {
        /* Remove the “best” move sequence from the Priorty Queue */
        Node delNode = searchNodes.delMin();
        // System.out.println(delNode.moves);
        /* Stop once reach the Goal */
        if (delNode.worldState.isGoal()) {
            Node pathNode = delNode;
            /* Add solution path of worldStates */
            while (pathNode != null) {
                sol.add(pathNode.worldState);
                pathNode = pathNode.parentNode;
            }
            return delNode.moves;
        }
        /* Add all neighbors to the Priority Queue except the grandparent Node */
        for (WorldState neighbor : delNode.worldState.neighbors()) {
            if (delNode.parentNode == null || !delNode.parentNode.worldState.equals(neighbor)) {
                Node n = new Node(neighbor, delNode, delNode.moves + 1);
                searchNodes.insert(n);
            }
        }
        return solverHelper(searchNodes);
    }

    public int moves() {
        return moves;
    }

    public Iterable<WorldState> solution() {
        return sol;
    }
}
