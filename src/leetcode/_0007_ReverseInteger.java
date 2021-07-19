package leetcode;

import java.math.BigInteger;
import java.util.Stack;

/**
 * int 2의 31승 단순히 -를 +로 바꾸면 int형으로 사용할 수가 없다. long형으로 바꾸거나..
 *
 * -2147483648 to 2147483647
 */
public class _0007_ReverseInteger {
    public int reverse(int x) {

        if (x > Math.pow(2, 31) - 1 || x < Math.pow(-2, 31) || x == 0) {
            return 0;
        }

        String s = String.valueOf(x);
        String split [] = s.split("");
        String result [] = new String[split.length];
        boolean firstZero = true;
        for (int i=0; i< split.length; i++) {
            if (split[i].equals("-")) {
                continue;
            }
            int v = Integer.parseInt(split[i]);
            if (v == 0 && firstZero) {
                continue;
            } else {
                firstZero = false;
            }
            int disit = v % 10;
            result[split.length-1-i] = String.valueOf(disit);
        }

        String rr = String.join("", result).replace("null","");
        if (x < 0) {
            rr = "-" + rr;
        }
        long re = Long.parseLong(rr);
        if (re > Math.pow(2, 31) - 1 || re < Math.pow(-2, 31) || re == 0) {
            return 0;
        }
        //return Integer.parseInt(rr);
        return (int)(re);
    }

    public int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

}
