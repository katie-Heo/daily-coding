import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class Lesson2Test extends TestCase {

    private Lesson2 lesson2 = new Lesson2();

    @Test
    public void test1() {
        int[] A = {3,8,9,7,6};
        int K = 3;

        int [] actual = lesson2.solution(A, K);
        Assert.assertArrayEquals(new int[]{9,7,6,3,8}, actual);
    }


    @Test
    public void test2() {
        int[] A = {0,0,0};
        int K = 1;

        int [] actual = lesson2.solution(A, K);
        Assert.assertArrayEquals(new int[]{0,0,0}, actual);
    }

    @Test
    public void test3() {
        int[] A = {1,2,3,4};
        int K = 4;

        int [] actual = lesson2.solution(A, K);
        Assert.assertArrayEquals(new int[]{1,2,3,4}, actual);
    }
}