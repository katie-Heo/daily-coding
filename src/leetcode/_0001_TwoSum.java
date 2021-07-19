package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i< nums.length - 1 ; i++) {
            for (int j = i+1; j<nums.length; j++) {

                if ((nums[i] + nums[j]) == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumBest(int[] nums, int target) {
        String a ="1";
        Integer.parseInt(a);

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i, map.get(complement)};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
