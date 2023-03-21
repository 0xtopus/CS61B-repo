package lab9tester;

import static org.junit.Assert.*;

import org.junit.Test;
import lab9.BSTMap;

import java.util.Set;

/**
 * Tests by Brendan Hu, Spring 2015, revised for 2018 by Josh Hug
 */
public class TestBSTMap {

    @Test
    public void sanityGenericsTest() {
        try {
            BSTMap<String, String> a = new BSTMap<String, String>();
            BSTMap<String, Integer> b = new BSTMap<String, Integer>();
            BSTMap<Integer, String> c = new BSTMap<Integer, String>();
            BSTMap<Boolean, Integer> e = new BSTMap<Boolean, Integer>();
        } catch (Exception e) {
            fail();
        }
    }

    // assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1 + i);
            // make sure put is working via containsKey and get
            assertTrue(null != b.get("hi" + i));
            assertTrue(b.get("hi" + i).equals(1 + i));
            assertTrue(b.containsKey("hi" + i));
        }
        assertEquals(455, b.size());
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(null, b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertTrue(((Integer) b.get("starChild")).equals(5));
        b.put("KISS", 5);
        assertTrue(((Integer) b.get("KISS")).equals(5));
        assertNotEquals(null, b.get("starChild"));
        assertEquals(2, b.size());
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals(456, b.size());
    }

    // assumes get/containskey work
    @Test
    public void sanityPutTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi"));
        assertTrue(b.get("hi") != null);
    }

    @Test
    public void keySetTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1 + i);
            // make sure put is working via containsKey and get
            assertTrue(null != b.get("hi" + i));
            assertTrue(b.get("hi" + i).equals(1 + i));
            assertTrue(b.containsKey("hi" + i));
        }
        Set<String> bKeySet = b.keySet();
        for (int i = 0; i < 455; i++) {
            assertTrue(bKeySet.contains("hi" + i));
        }
        assertFalse(bKeySet.contains("ingenting")); // "ingenting" means "nothing" in Norwegian
    }

    /*
     * This test simulates the example
     * showed in video in the Delete part of official text book
     * 
     * @Source https://joshhug.gitbooks.io/hug61b/content/chap10/chap102.html
     */
    @Test
    public void removeKeyTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("dog", 1);
        b.put("bag", 2);
        b.put("flat", 3);
        b.put("alf", 4);
        b.put("cat", 5);
        b.put("glut", 6);
        b.put("elf", 7);
        b.put("eyes", 8);
        assertEquals(8, b.size());
        assertEquals((Integer) 6, b.get("glut"));

        // remove doesn't-exist
        assertNull(b.remove("ingenting"));

        // remove a leaf "glut" - 6
        assertEquals((Integer) 6, b.remove("glut"));
        assertEquals(7, b.size());
        assertNull(b.get("glut"));

        // remove a node with a sub-node "flat" - 3
        assertEquals((Integer) 3, b.remove("flat"));
        assertEquals(6, b.size());
        assertEquals((Integer) 7, b.get("elf"));

        // remove a node with 2 sub-node "dog" - 1
        assertEquals((Integer) 1, b.remove("dog"));
        assertEquals(5, b.size());
        assertEquals((Integer) 5, b.get("cat"));

        assertEquals(5, b.size());
    }

    @Test
    public void removeKeyValueTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("dog", 1);
        b.put("bag", 2);
        b.put("flat", 3);
        b.put("alf", 4);
        b.put("cat", 5);
        b.put("glut", 6);
        b.put("elf", 7);
        b.put("eyes", 8);
        assertEquals(8, b.size());
        assertEquals((Integer) 6, b.get("glut"));

        // remove doesn't-exist
        assertNull(b.remove("ingenting", 123));

        // remove a key with a incompatible value
        assertNull(b.remove("glut", 384298));

        // remove a leaf "glut" - 6
        assertEquals((Integer) 6, b.remove("glut", 6));
        assertEquals(7, b.size());
        assertNull(b.get("glut"));

        // remove a node with a sub-node "flat" - 3
        assertEquals((Integer) 3, b.remove("flat", 3));
        assertEquals(6, b.size());
        assertEquals((Integer) 7, b.get("elf"));

        // remove a node with 2 sub-node "dog" - 1
        assertEquals((Integer) 1, b.remove("dog", 1));
        assertEquals(5, b.size());
        assertEquals((Integer) 5, b.get("cat"));

        assertEquals(5, b.size());
    }

    @Test
    public void iteratorTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("dog", 1);
        b.put("bag", 2);
        b.put("flat", 3);
        b.put("alf", 4);
        b.put("cat", 5);
        b.put("glut", 6);
        b.put("elf", 7);
        b.put("eyes", 8);
        // check output print to verify it works
        for (String k : b) {
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMap.class);
    }
}
