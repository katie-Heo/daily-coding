package leetcode;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 문제 접근을 완전히 다르게 했고, 데이터 길이가 어마어마하게 커질경우는 Sum 으로 형변환이 안되서 에러가 났음.
 * 결국엔 자리수별로 더해서 왼쪽에서 오른쪽으로 연산하고 10을 넘는 숫자만 더하면 결과가 나옴
 *
 */
public class _0002_AddTwoNumbers {

    private int re;

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        LinkedList<String> linkedList1 = new LinkedList<>();
        BigInteger first = re(l1, linkedList1);

        LinkedList<String> linkedList2 = new LinkedList<>();
        BigInteger second = re(l2, linkedList2);

        BigInteger sum = first.add (second);
        String stringSum = String.valueOf(sum);
        String split [] = stringSum.split("");

        ListNode result = new ListNode(Integer.parseInt(split[0]));
        ListNode prev = result;
        for(int i = 1; i<split.length; i++) {

            ListNode next = new ListNode(Integer.parseInt(split[i]), prev);
            prev = next;
        }

        return prev;
    }

    private BigInteger re(ListNode l1, LinkedList linkedList1) {
        ListNode next = l1;
        while(next != null) {
            linkedList1.push(String.valueOf(next.val));
            next = next.next;
        }

        String join1 = "";
        for (int i=0; i<linkedList1.size(); i++) {
            join1 += linkedList1.get(i);
        }

        return BigInteger.valueOf(Long.parseLong(join1) );
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2)     {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode tempListNode = result;
        while((l1 != null) || (l2 != null)){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1= l1.next;
            }
            if(l2!=null){
                sum+= l2.val;
                l2=l2.next;
            }
            if(carry != 0)
                sum+= carry;

            carry = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            tempListNode.next = node;
            tempListNode= tempListNode.next;
        }
        if(carry != 0)
            tempListNode.next= new ListNode(carry);
        return result.next;

    }

}
