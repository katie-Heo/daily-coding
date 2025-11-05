package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class _0146_LRUCacheTest extends TestCase {

    @Test
    public void test() {
        _0146_LRUCache lRUCache = new _0146_LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        assertEquals(1, lRUCache.get(1));;    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2));   // returns -1 (not found)
        lRUCache.put(4, 4);
        assertEquals(-1, lRUCache.get(1));   // return -1 (not found)
        assertEquals(3, lRUCache.get(3));    // return 3
        assertEquals(4, lRUCache.get(4));    // return 4
    }
}