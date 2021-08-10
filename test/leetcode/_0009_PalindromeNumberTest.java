package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0009_PalindromeNumberTest {

    _0009_PalindromeNumber solution;
    @Before
    public void setUp() throws Exception {
        solution = new _0009_PalindromeNumber();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        int x = 121;
        Assert.assertEquals(true, solution.isPalindrome(x));
    }

    @Test
    public void test2() {
        int x = -121;
        Assert.assertFalse(solution.isPalindrome(x));
    }

    @Test
    public void test3() {
        int x = 10;
        Assert.assertFalse(solution.isPalindrome(x));
    }
    @Test
    public void test4() {
        int x = -101;
        Assert.assertFalse(solution.isPalindrome(x));
    }
    @Test
    public void test5() {
        int x = Integer.MIN_VALUE;
        Assert.assertFalse(solution.isPalindrome(x));
    }

    @Test
    public void test6() {
        int x = 1234321;
        Assert.assertTrue(solution.isPalindrome(x));
    }
    @Test
    public void test7() {
        int x = -2147447412;
        Assert.assertFalse(solution.isPalindrome(x));
    }
}