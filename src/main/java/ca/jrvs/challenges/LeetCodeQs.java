package main.java.ca.jrvs.challenges;

import java.util.*;
import java.util.stream.IntStream;

public class LeetCodeQs {

    public boolean isRectangleOverlapArea(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }

    public boolean isRectangleOverlapPosition(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    /**
     * #67
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            c = sum / 2;
            sb.append(sum % 2);
        }

        if (c != 0) sb.append(c);
        return sb.reverse().toString();
    }

    /**
     * #390. There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
     *
     * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
     *
     * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
     *
     * Find the last number that remains starting with a list of length n.
     * @param n
     * @return
     */
    public static int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    /**
     * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
     * @param S
     * @return
     */
    public static String reverseOnlyLetters2ptr(String S) {
        StringBuilder sb = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                sb.append(S.charAt(j--));
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)){
                stack.add(c);
            }
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (Character.isLetter(s.charAt(i))) {
                chars[i] = stack.pop();
            }
        }
        return new String(chars);
    }


    /**
     * Create a method that will print natural number (in String) with comma(s)
     * e.g.
     * input (String): "12345"    output: "12,345"
     * input:          "1234567"   output: "1,234,567
     * @param s
     */
    public static void naturalNumber(String s) {
        if (!s.matches("\\d*")) {
           throw new IllegalArgumentException(s + "is not a number");
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i != 0 && i % 3 == s.length() % 3) {
                sb.append(",").append(c);
            } else {
                sb.append(c);
            } i++;
        }

        System.out.println(sb.toString());
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2 + 1;

        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                if (map.get(i) == target - 1) {
                    return i;
                }
                map.replace(i, map.get(i) + 1);
            }
        }
        return -1;
    }
    
    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        boolean carry = false;

        while (l1.next != null && l2.next != null) {
            int sum, val1, val2, c = 0;
            val1 = (l1.next == null) ? 0 : l1.next.val;
            val2 = (l2.next == null) ? 0 : l2.next.val;
            if (carry) { c = 1; }

            sum = val1 + val2 + c;
            if (sum - 10 > 0) {
                carry = true;
                result.val = sum - 10;
            } else {
                result.val = sum;
            }

            result.next = new ListNode(0);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(reverseOnlyLetters2ptr("ab-cd-ef-gh"));
//        naturalNumber("12345");

//        int[] nums = new int[]{1,2,1};
//        System.out.println(majorityElement(nums));

        boolean[] notPrime = new boolean[10];
        if (!notPrime[0]){
            System.out.println("false");
        }

    }
}
