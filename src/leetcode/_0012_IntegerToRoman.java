package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0012_IntegerToRoman {
    public String intToRoman(int num) {
        if (1 > num || 3999 < num) {
            return "";
        }

        int [] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int mod = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< arr.length; i++) {
            if (num < arr[i]) {
                continue;
            }
            mod = num / arr[i];
            for (int j = 0; j < mod; j++) {
                sb.append(symbol[i]);
            }

            num = num % arr[i];
        }

        return sb.toString();
    }
    public String intToRoman2(int num) {

        StringBuilder sb = new StringBuilder();

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                sb.append(roman[i]);
                num -= nums[i];
            }
        }

        return sb.toString();
    }

}
