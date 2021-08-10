package leetcode;

public class _0009_PalindromeNumber {
    public boolean isPalindrome(int x) {

        long abs = x;
        if (x < 0) {
            abs = Math.abs(x);
            return false;
        }

        String temp = Long.toString(abs);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }

        int i = 0 ;
        int j = temp.length() - 1;
        while(i < j) {
            if (numbers[i] != numbers[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }

        int first = x;
        long reverse = 0;

        while(x>0){
            reverse = reverse*10 + x%10;
            x /= 10;
        }

        if(reverse == first){
            return true;
        }else{
            return false;
        }
    }
}
