package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0012_IntegerToRomanTest {

    _0012_IntegerToRoman solution;
    @Before
    public void setUp() throws Exception {
        solution = new _0012_IntegerToRoman();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test1() {
        int num = 3;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("III", actual);
    }
    @Test
    public void test2() {
        int num = 4;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("IV", actual);
    }
    @Test
    public void test3() {
        int num = 9;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("IX", actual);
    }
    @Test
    public void test4() {
        int num = 58;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("LVIII", actual);
    }
    @Test
    public void test5() {
        int num = 1994;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("MCMXCIV", actual);
    }

    @Test
    public void test6() {
        int num = 1993;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("MCMXCIII", actual);
    }

    @Test
    public void test7() {
        int num = 27;
        String actual = solution.intToRoman(num);
        Assert.assertEquals("XXVII", actual);
    }


}