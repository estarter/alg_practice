package union_find;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UnionFindTest {

    @Test
    void initialState() {
        UnionFind uf = new UnionFind(5);
        assertEquals(5, uf.componentCount());
        for (int i = 0; i < 5; i++) {
            assertEquals(i, uf.find(i));
        }
    }

    @Test
    void unionReducesComponentCount() {
        UnionFind uf = new UnionFind(4);
        uf.union(0, 1);
        assertEquals(3, uf.componentCount());
        uf.union(2, 3);
        assertEquals(2, uf.componentCount());
        uf.union(0, 2);
        assertEquals(1, uf.componentCount());
    }

    @Test
    void connectedAfterUnion() {
        UnionFind uf = new UnionFind(5);
        assertFalse(uf.connected(0, 4));
        uf.union(0, 1);
        uf.union(1, 2);
        assertTrue(uf.connected(0, 2));
        assertFalse(uf.connected(0, 3));
    }

    @Test
    void duplicateUnionIsIdempotent() {
        UnionFind uf = new UnionFind(3);
        uf.union(0, 1);
        assertEquals(2, uf.componentCount());
        uf.union(0, 1);
        assertEquals(2, uf.componentCount());
        uf.union(1, 0);
        assertEquals(2, uf.componentCount());
    }

    @Test
    void transitiveConnectivity() {
        UnionFind uf = new UnionFind(6);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(4, 5);
        assertTrue(uf.connected(0, 2));
        assertTrue(uf.connected(3, 5));
        assertFalse(uf.connected(2, 3));

        uf.union(2, 3);
        assertTrue(uf.connected(0, 5));
        assertEquals(1, uf.componentCount());
    }

    @Test
    void singleElement() {
        UnionFind uf = new UnionFind(1);
        assertEquals(1, uf.componentCount());
        assertEquals(0, uf.find(0));
        assertTrue(uf.connected(0, 0));
    }

    @Test
    void largerGraph() {
        int n = 1000;
        UnionFind uf = new UnionFind(n);
        // connect all even numbers
        for (int i = 2; i < n; i += 2) {
            uf.union(0, i);
        }
        // connect all odd numbers
        for (int i = 3; i < n; i += 2) {
            uf.union(1, i);
        }
        assertEquals(2, uf.componentCount());
        assertTrue(uf.connected(0, 998));
        assertTrue(uf.connected(1, 999));
        assertFalse(uf.connected(0, 1));

        uf.union(0, 1);
        assertEquals(1, uf.componentCount());
        assertTrue(uf.connected(0, 1));
    }
}
