package leetcode;

import static org.junit.Assert.*;

import leetcode._0002_AddTwoNumbers.ListNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0002_AddTwoNumbersTest {
    private _0002_AddTwoNumbers solution;

    @Before
    public void setUp() throws Exception {
        solution = new _0002_AddTwoNumbers();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void test1() {
        ListNode l1_3 = new ListNode(3);
        ListNode l1_2 = new ListNode(4, l1_3);
        ListNode l1_1 = new ListNode(2, l1_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_3);
        ListNode l2_1 = new ListNode(5, l2_2);

        ListNode expect = solution.addTwoNumbers(l1_1, l2_1);
        Assert.assertEquals(expect.val, 7);

        ListNode next1 = expect.next;
        Assert.assertEquals(next1.val, 0);

        ListNode next2 = next1.next;
        Assert.assertEquals(next2.val, 8);
    }

    @Test
    public void test2() {
        ListNode l1_7 = new ListNode(9);
        ListNode l1_6 = new ListNode(9, l1_7);
        ListNode l1_5 = new ListNode(9, l1_6);
        ListNode l1_4 = new ListNode(9, l1_5);
        ListNode l1_3 = new ListNode(9, l1_4);
        ListNode l1_2 = new ListNode(9, l1_3);
        ListNode l1_1 = new ListNode(9, l1_2);

        ListNode l2_4 = new ListNode(9);
        ListNode l2_3 = new ListNode(9, l2_4);
        ListNode l2_2 = new ListNode(9, l2_3);
        ListNode l2_1 = new ListNode(9, l2_2);

        ListNode expect = solution.addTwoNumbers(l1_1, l2_1);
        Assert.assertEquals(expect.val, 8);

        ListNode next1 = expect.next;
        Assert.assertEquals(next1.val, 9);

        ListNode next2 = next1.next;
        Assert.assertEquals(next2.val, 9);

        ListNode next3 = next2.next;
        Assert.assertEquals(next3.val, 9);

        ListNode next4 = next3.next;
        Assert.assertEquals(next4.val, 0);

        ListNode next5 = next4.next;
        Assert.assertEquals(next5.val, 0);

        ListNode next6 = next5.next;
        Assert.assertEquals(next6.val, 0);

        ListNode next7 = next6.next;
        Assert.assertEquals(next7.val, 1);

    }


    @Test
    public void test3() {
        ListNode l1_1 = new ListNode(0);

        ListNode l2_1 = new ListNode(0);

        ListNode expect = solution.addTwoNumbers(l1_1, l2_1);
        Assert.assertEquals(expect.val, 0);
    }
}