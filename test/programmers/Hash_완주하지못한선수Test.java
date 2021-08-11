package programmers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Hash_완주하지못한선수Test {
    Hash_완주하지못한선수 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Hash_완주하지못한선수();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }
    @Test
    public void test1() {
        String participant []= {"leo", "kiki", "eden"};
        String completion []= {"eden", "kiki"};
        String actual = solution.solution(participant, completion);
        Assert.assertEquals("leo", actual);
    }

    @Test
    public void test2() {
        String participant []= {"marina", "josipa", "nikola", "vinko", "filipa"};
        String completion []= {"josipa", "filipa", "marina", "nikola"};
        String actual = solution.solution(participant, completion);
        Assert.assertEquals("vinko", actual);
    }

    @Test
    public void test3() {
        String participant []= {"mislav", "stanko", "mislav", "ana"};
        String completion []= {"stanko", "ana", "mislav"};
        String actual = solution.solution(participant, completion);
        Assert.assertEquals("mislav", actual);
    }
}