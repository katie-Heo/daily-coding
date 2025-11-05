package leetcode;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.Arrays;

public class _0347_TopKFrequentElementsTest extends TestCase {

    @Test
    public void test() {
        _0347_TopKFrequentElements solution = new _0347_TopKFrequentElements();
        
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1,2};
        int[] result = solution.topKFrequent(nums, k);
        
        Arrays.sort(result);
        Arrays.sort(expected);
        assertTrue(Arrays.equals(expected, result));
    }
}