package programmers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Hash_위장Test {

    Hash_위장 solution;
    @Before
    public void setUp() throws Exception {
        solution = new Hash_위장();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test1() {
        String clothes [][]= {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int actual = solution.solution(clothes);
        Assert.assertEquals(5, actual);
    }

    @Test
    public void test2() {
        String clothes [][]= {{"crowmask", "face"},{"bluesunglasses", "face"},{"smoky_makeup", "face"}};
        int actual = solution.solution(clothes);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test3() {
        String clothes [][]= {{"crowmask", "face"},{"bluesunglasses", "face"},{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int actual = solution.solution(clothes);
        Assert.assertEquals(9, actual);
    }


    @Test
    public void test4() {
        String clothes [][]= {{"pinkmakup", "face"},{"crowmask", "face"},{"bluesunglasses", "face"},{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int actual = solution.solution(clothes);
        Assert.assertEquals(12, actual);
    }
}