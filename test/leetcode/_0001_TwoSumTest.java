package leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0001_TwoSumTest {
    private _0001_TwoSum solution;

    @Before
    public void setUp() throws Exception {
        solution = new _0001_TwoSum();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test1() {
        int nums [] = {2,7,11,15};
        int target = 9;
        int expected[] = solution.twoSum(nums, target);
        Assert.assertArrayEquals(expected, new int[] {0, 1});
    }
    @Test
    public void test2() {
        int nums [] = {3,2,4};
        int target = 6;
        int expected[] = solution.twoSum(nums, target);
        Assert.assertArrayEquals(expected, new int[] {1, 2});
    }
    @Test
    public void test3() {
        int nums [] = {3,3};
        int target = 6;
        int expected[] = solution.twoSum(nums, target);
        Assert.assertArrayEquals(expected, new int[] {0, 1});
    }

    @Test
    public void test4() {
        int nums [] = {2,5,5,11};
        int target = 10;
        int expected[] = solution.twoSum(nums, target);
        Assert.assertArrayEquals(expected, new int[] {1, 2});
    }

}