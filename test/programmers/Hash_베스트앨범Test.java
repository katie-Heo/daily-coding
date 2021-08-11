package programmers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Hash_베스트앨범Test {
    Hash_베스트앨범 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Hash_베스트앨범();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        String genres []= {"classic", "pop", "classic", "classic", "pop"};
        int plays [] = {500, 600, 150, 800, 2500};

        int[] actual = solution.solution(genres, plays);
        Assert.assertArrayEquals(new int [] {4,1,3,0}, actual);
    }
}