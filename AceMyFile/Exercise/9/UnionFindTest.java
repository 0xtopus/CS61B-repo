import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {
    @Test
    public void testUFConstructor(){
        UnionFind uf = new UnionFind(8);
        for(int i = 0; i < 8; i++) {
            assertEquals(-1, uf.parent(i));
        }
    }
    
    @Test
    public void testUFFind(){
        UnionFind uf = new UnionFind(8);
        for(int i = 0; i < 8; i++) {
            assertEquals(-1, uf.parent(i));
            assertEquals(i, uf.find(i));
        }
    }

    @Test
    public void testUF(){
        UnionFind uf = new UnionFind(8);
        uf.union(0, 2);
        uf.union(0, 4);
        assertEquals(3, uf.sizeOf(0));
        assertFalse(uf.connected(0, 3));
        assertTrue(uf.connected(4, 2));

        uf.union(3, 1);
        uf.union(5, 1);
        uf.union(3, 7);
        assertEquals(4, uf.sizeOf(7));
        assertTrue(uf.connected(7, 1));

        assertFalse(uf.connected(4, 5));
        uf.union(7, 0);
        assertTrue(uf.connected(4, 5));

        assertEquals(2, uf.parent(0));
        uf.union(6, 0);
        assertEquals(1, uf.parent(0));
        assertEquals(1, uf.parent(4));

        // test validate
        try {
            uf.union(99, 0);
        } catch(RuntimeException e) {
            System.out.println("test passed!");
        }
        
    }
}
