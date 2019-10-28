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

    private static int tilt = 0;

    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        findTilt(root.left);

        if (root.left != null) {
            tilt += root.left.val;
        } if (root.right != null) {
            tilt = Math.abs(tilt - root.right.val);
        }

        findTilt(root.right);
        return tilt;
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> resList = new ArrayList<>(numRows);
        if (numRows == 0) return resList;
        resList.add(Arrays.asList(1));
        if (numRows == 1) return resList;

        for (int row = 2; row <= numRows; row++){
            List<Integer> ls = new ArrayList<>(row);
            ls.add(1);
            for (int i = 1; i < row - 1; i++){
                ls.add(resList.get(row - 2).get(i - 1) +
                        resList.get(row - 2).get(i));
            }
            ls.add(1);
            resList.add(ls);
        }
        return resList;
    }

    public static List<String> fizzBuzz(int n){
        List<String> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            String s = "";
            if ((i % 3) == 0) {
                s += "Fizz";
            }
            if ((i % 5) == 0) {
                s += "Buzz";
            }
            if (s.length() == 0){
                s += Integer.toString(i);
            }
            ls.add(s);
        }
        return ls;
    }

    public static List<String> fizzBuzzOp(int n){
        List<String> ls = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int i = 1; i <= n; i++) {
            String s = "";
            for (Integer k : map.keySet()) {
                if (i % k == 0) {
                    s += map.get(k);
                }
            }
            if (s.length() == 0) {
                s += Integer.toString(i);
            }
            ls.add(s);
        }
        return ls;
    }

    /**
     * LeetCode 387 FIrst Unique Character in a String
     * @param s
     * @return index
     */
    public static int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


    public static void main(String[] args) {
//        System.out.println(reverseOnlyLetters2ptr("ab-cd-ef-gh"));
//        naturalNumber("12345");

//        int[] nums = new int[]{1,2,1};
//        System.out.println(majorityElement(nums));

//        boolean[] notPrime = new boolean[10];
//        if (!notPrime[0]){
//            System.out.println("false");
//        }

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//
//        System.out.println(findTilt(root));

//        List<List<Integer>> resList = generate(5);
//
//        for (List l : resList){
//            for (Object i: l){
//                System.out.println(i);
//            }
//        }

//        for (String s : fizzBuzzOp(15)){
//            System.out.println(s);
//        }


    }
}
