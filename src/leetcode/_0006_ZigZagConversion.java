package leetcode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class _0006_ZigZagConversion {
    public String convert(String s, int numRows) {

        if (s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i< numRows; i++) {
            rows.add(new StringBuilder());
        }

        int idx = 0;
        while(idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++) {
                rows.get(i).append(s.charAt(idx++));
            }
            for (int i = numRows-2; i> 0 && idx < s.length(); i--) {
                rows.get(i).append(s.charAt(idx++));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb.toString());
        }
        return ans.toString();
    }

    // 최적의 답
    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
