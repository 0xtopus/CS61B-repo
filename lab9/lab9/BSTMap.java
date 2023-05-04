package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author 0xtopus
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root; /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns the value mapped to by KEY in the subtree rooted in P.
     * or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (p.key.equals(key)) {
            return p.value;
        }
        if (p.key.compareTo(key) < 0) {
            return getHelper(key, p.right);
        } else {
            return getHelper(key, p.left);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /**
     * Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
     * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size++;
            return new Node(key, value);
        }
        if (p.key.equals(key)) {
            p.value = value;
        }
        if (p.key.compareTo(key) < 0) {
            p.right = putHelper(key, value, p.right);
        } else {
            p.left = putHelper(key, value, p.left);
        }
        return p;
    }

    /**
     * Inserts the key KEY
     * If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> ks = new HashSet<>();
        keySetHelper(ks, root);
        return ks;
    }

    /* recursivly add all sub-node of given Node n and itself to the Set */
    private void keySetHelper(Set<K> ks, Node n) {
        if (n == null) {
            return;
        }
        ks.add(n.key);
        keySetHelper(ks, n.left);
        keySetHelper(ks, n.right);
    }

    /**
     * Removes KEY from the tree if present
     * returns VALUE removed,
     * null on failed removal.
     */
    @Override
    public V remove(K key) {
        V keyValue = get(key);
        if (keyValue == null) {
            return null;
        }
        root = removeHelper(key, root);
        return keyValue;
    }

    /**
     * Removes the key-value entry for the specified key only if it is
     * currently mapped to the specified value. Returns the VALUE removed,
     * null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        V keyValue = get(key);
        if (keyValue != value) {
            return null;
        }
        if (size == 1) {
            root = null;
        }
        root = removeHelper(key, root);
        return keyValue;
    }

    /* Helper method to remove */
    public Node removeHelper(K key, Node p) {
        // Given key not found
        if (p == null) {
            return null;
        }
        // Given key found
        if (p.key.equals(key)) {
            // decrease the size by 1
            size--;
            if (p.left == null && p.right == null) {
                // p is a leaf
                p = null;
                return p;
            } else if (p.left != null && p.right != null) {
                // p has two sub-nodes
                Node predecessor = findPredecessor(p);
                if (predecessor == null) {
                    Node pRight = p.right;
                    p.key = p.left.key;
                    p.value = p.left.value;
                    p.left = p.left.left;
                    p.right = pRight;
                } else {
                    p.value = predecessor.value;
                    p.key = predecessor.key;
                }
/*                 if (predecessor.right == null) {
                    p.left = p.left.left;
                } */
                return p;
            } else if (p.left != null) {
                // p only has one left sub-node

                p.value = p.left.value;
                p.key = p.left.key;
                p.right = p.left.right;
                p.left = p.left.left;

                return p;
            } else if (p.right != null) {
                // p only has one right sub-node
                p.value = p.right.value;
                p.key = p.right.key;
                p.left = p.right.left;
                p.right = p.right.right;

                return p;
            }
        }
        if (p.key.compareTo(key) < 0) {
            p.right = removeHelper(key, p.right);
        } else if (p.key.compareTo(key) > 0) {
            p.left = removeHelper(key, p.left);
        }
        return p;
    }

    /*
     * Find the predecessor
     * Predecessor: be > than everything in left subtree.
     */
    private Node findPredecessor(Node p) {
        p = p.left;
        Node prev = p;
        while (p.right != null) {
            prev = p;
            p = p.right;
        }
        if (p == prev) {
            return null;
        }
        prev.right = null;
        return p;
    }

    @Override
    public Iterator<K> iterator() {
        Set<K> ks = keySet();
        return ks.iterator();
    }

}
