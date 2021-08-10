package programmers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DFS_TargetNumberTest {

    DFS_TargetNumber solution;
    @Before
    public void setUp() throws Exception {
        solution = new DFS_TargetNumber();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    /**
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     */
    @Test
    public void test1() {
        int nums [] = {1, 1, 1, 1, 1};
        int actual = solution.solution(nums, 3);
        Assert.assertEquals(5, actual);
    }

    /**
     * -1+1+1+1+1 = 0
     */
    @Test
    public void test2() {
        int nums [] = {1, 1, 1, 1, 1};
        int actual = solution.solution(nums, 4);
        Assert.assertEquals(5, actual);
    }
    /**
     * -1+1+1+1 = 2
     * +1-1+1+1 = 2
     * +1+1-1+1 = 2
     * +1+1+1-1 = 2
     *
     */
    @Test
    public void test3() {
        int nums [] = {1, 1, 1, 1};
        int actual = solution.solution(nums, 2);
        Assert.assertEquals(4, actual);
    }
}