package programmers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Hash_전화번호목록Test {
    Hash_전화번호목록 solution;
    @Before
    public void setUp() throws Exception {
        solution = new Hash_전화번호목록();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        String phone_book []= {"119", "97674223", "1195524421"};
        boolean actual = solution.solution(phone_book);
        Assert.assertEquals(false, actual);
    }
    @Test
    public void test2() {
        String phone_book []= {"123","456","789"};
        boolean actual = solution.solution(phone_book);
        Assert.assertEquals(true, actual);
    }
    @Test
    public void test3() {
        String phone_book []= {"12","123","1235","567","88"};
        boolean actual = solution.solution(phone_book);
        Assert.assertEquals(false, actual);
    }
}