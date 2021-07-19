package leetcode;

import static org.junit.Assert.*;

import java.awt.SystemTray;
import java.math.BigInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0007_ReverseIntegerTest {
    private _0007_ReverseInteger solution;

    @Before
    public void setUp() throws Exception {
        solution = new _0007_ReverseInteger();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        int x = 123;
        Assert.assertEquals(solution.reverse(x), 321);
    }

    @Test
    public void test2() {
        int x = -123;
        Assert.assertEquals(solution.reverse(x), -321);
    }

    @Test
    public void test3() {
        int x = 120;
        Assert.assertEquals(solution.reverse(x), 21);
    }

    @Test
    public void test4() {
        int x = 0;
        Assert.assertEquals(solution.reverse(x), 0);
    }
    @Test
    public void test5() {
        int x = 1534236469;
        Assert.assertEquals(solution.reverse(x), 0);
    }
  @Test
    public void test6() {
        int x = -2147483648;
        Assert.assertEquals(solution.reverse1(x), 0);
    }

}