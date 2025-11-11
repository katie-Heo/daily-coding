package leetcode;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.Arrays;

public class _0347_TopKFrequentElementsTest extends TestCase {

    @Test
    public void test() {
        _0347_TopKFrequentElements solution = new _0347_TopKFrequentElements();

        {
            int[] nums = {1, 1, 1, 2, 2, 3};
            int k = 2;
            int[] expected = {1, 2};
            int[] result = solution.topKFrequent(nums, k);

            Arrays.sort(result);
            assertTrue(Arrays.equals(expected, result));
        }
        {
            int[] nums = {1};
            int k = 1;
            int[] expected = {1};
            int[] result = solution.topKFrequent(nums, k);
            Arrays.sort(result);
            assertTrue(Arrays.equals(expected, result));
        }
        {
            int[] nums = {1,2,1,2,1,2,3,1,3,2};
            int k = 2;
            int[] expected = {1, 2};
            int[] result = solution.topKFrequent(nums, k);
            Arrays.sort(result);
            assertTrue(Arrays.equals(expected, result));
        }

    }
}