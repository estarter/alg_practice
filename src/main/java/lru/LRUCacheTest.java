package lru;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void test1() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);
        cache.put(2, "1");
        assertEquals("1", cache.get(2));
        cache.put(3, "2");
        assertEquals(null, cache.get(2));
        assertEquals("2", cache.get(3));
    }

    @Test
    void test2() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "1");
        cache.put(2, "2");
        assertEquals("1", cache.get(1));
        cache.put(3, "3");
        assertEquals(null, cache.get(2));
        cache.put(4, "4");
        assertEquals(null, cache.get(1));
        assertEquals("3", cache.get(3));
        assertEquals("4", cache.get(4));

        cache.put(2, "1");
        cache.put(2, "2");
        assertEquals("2", cache.get(2));
    }

    @Test
    void test3() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        assertEquals(null, cache.get(2));
        cache.put(2, "6");
        assertEquals(null, cache.get(1));
        cache.put(1, "5");
        cache.put(1, "2");
        assertEquals("2", cache.get(1));
        assertEquals("6", cache.get(2));
    }
}