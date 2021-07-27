package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0006_ZigZagConversionTest {
    private _0006_ZigZagConversion solution;
    @Before
    public void setUp() throws Exception {
        solution = new _0006_ZigZagConversion();

    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        String input = "PAYPALISHIRING";
        String actual = solution.convert(input, 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", actual);
    }
    @Test
    public void test2() {
        String input = "PAYPALISHIRING";
        String actual = solution.convert(input, 4);
        Assert.assertEquals("PINALSIGYAHRPI", actual);
    }
    @Test
    public void test3() {
        String input = "A";
        String actual = solution.convert(input, 1);
        Assert.assertEquals("A", actual);
    }

    @Test
    public void test4() {
        String input = "AB";
        String actual = solution.convert(input, 2);
        Assert.assertEquals("AB", actual);
    }
}