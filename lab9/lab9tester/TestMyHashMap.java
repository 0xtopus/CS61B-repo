package lab9tester;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import lab9.MyHashMap;

/**
 * Tests by Brendan Hu, Spring 2015, revised for 2018 by Josh Hug
 */
public class TestMyHashMap {

    @Test
    public void sanityGenericsTest() {
        try {
            MyHashMap<String, String> a = new MyHashMap<String, String>();
            MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
            MyHashMap<Integer, String> c = new MyHashMap<Integer, String>();
            MyHashMap<Boolean, Integer> e = new MyHashMap<Boolean, Integer>();
        } catch (Exception e) {
            fail();
        }
    }

    // assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            // make sure put is working via containsKey and get
            assertTrue(null != b.get("hi" + i)
                    && b.containsKey("hi" + i));
        }
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        assertEquals(null, b.get("starChild"));
        b.put("starChild", 5);
        assertNotEquals(null, b.get("starChild"));
        b.put("KISS", 5);
        assertNotEquals(null, b.get("KISS"));
        assertNotEquals(null, b.get("starChild"));
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
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
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    /*
     * Test for general functionality and that the properties of Maps hold.
     */
    @Test
    public void functionalityTest() {
        MyHashMap<String, String> dictionary = new MyHashMap<>();
        assertEquals(0, dictionary.size());

        // can put objects in dictionary and get them
        dictionary.put("hello", "world");
        assertTrue(dictionary.containsKey("hello"));
        assertEquals("world", dictionary.get("hello"));
        assertEquals(1, dictionary.size());

        // putting with existing key updates the value
        dictionary.put("hello", "kevin");
        assertEquals(1, dictionary.size());
        assertEquals("kevin", dictionary.get("hello"));

        // putting key in multiple times does not affect behavior
        MyHashMap<String, Integer> studentIDs = new MyHashMap<>();
        studentIDs.put("sarah", 12345);
        assertEquals(1, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        assertTrue(studentIDs.containsKey("sarah"));
        assertTrue(studentIDs.containsKey("alan"));

        // handle values being the same
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("evil alan", 345);
        assertEquals(345, studentIDs.get("evil alan").intValue());
        assertEquals(studentIDs.get("evil alan"), studentIDs.get("alan"));
    }

    @Test
    public void keySetTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
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
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
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
    }

    @Test
    public void removeKeyValueTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
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
    }

    @Test
    public void iteratorTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
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
        jh61b.junit.TestRunner.runTests(TestMyHashMap.class);
    }
}
