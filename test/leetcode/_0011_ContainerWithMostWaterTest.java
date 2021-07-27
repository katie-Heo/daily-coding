package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0011_ContainerWithMostWaterTest {

    _0011_ContainerWithMostWater solution;
    @Before
    public void setUp() throws Exception {
        solution = new _0011_ContainerWithMostWater();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        int height[] = {1,8,6,2,5,4,8,3,7};
        int actual = solution.maxArea(height);
        Assert.assertEquals(49, actual);
    }

    @Test
    public void test2() {
        int height[] = {1,1};
        int actual = solution.maxArea(height);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int height[] = {1,2,1};
        int actual = solution.maxArea(height);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test4() {
        int height[] = {3,9,3,4,7,2,12,6};
        int actual = solution.maxArea(height);
        Assert.assertEquals(45, actual);
    }
}