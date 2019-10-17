package main.java.ca.jrvs.challenges;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main4 {

    public static boolean isValidParanthesis(String s) {
        if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> parans = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (parans.empty()) {
                parans.push(s.charAt(i));
            } else if (map.get(parans.peek()) == null) {
                return false;
            } else if (s.charAt(i) == map.get(parans.peek())) {
                parans.pop();
            } else {
                parans.push(s.charAt(i));
            }
        }

        if (parans.empty()) {
            return true;
        }
        return false;
    }

    public static int[] removeDup(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int val : set){
            result[i++] = val;
        }
        return result;
    }

    public static void movingAverage(int[] arr, int windowSize){
        for (int i=0; i < arr.length - windowSize + 1; i++) {
            int sum = 0;
            for (int j=i; j < windowSize+i; j++) {
                sum += arr[j];
            }
            System.out.println((double)sum/windowSize);
        }
    }

    public static int countPrimes(int n) {
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true){
                primes++;
            }
        }
        return primes;
    }

    public static int countPrimes2(int n) {
        if(n <= 1) return 0;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i = 2; i < Math.sqrt(n); i++){
            if(!notPrime[i]){
                for(int j = 2; j*i < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }

        int count = 0;
        for(int i = 2; i< notPrime.length; i++){
            if(!notPrime[i]) count++;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //given linked list: 1->2->3->4->5 and n=2
        //removing 2nd node from end, linked list becomes 1->2->3->5

       ListNode dummy = new ListNode(0);
       dummy.next = head;
       int length = 0;
       ListNode first = head;
       while (first!=null){
           length++;
           first = first.next;
       }
       length -= n;
       first = dummy;
       while (length > 0){
           length--;
           first = first.next;
       }
       first.next = first.next.next;
       return dummy.next;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] merged = new int[n+m];
        int i = 0, j = 0, k = 0;
        while (k < merged.length){
            if (i<m && j<n){
                if (nums1[i] < nums2[j]){
                    merged[k] = nums1[i];
                    i++;
                } else {
                    merged[k] = nums2[j];
                    j++;
                }
            } k++;
        }
        System.out.println(Arrays.toString(merged));
    }

    public boolean hasCycle(ListNode head){
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)){
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleTwoPtrs(ListNode head){
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseListIterative(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {

//        int[] nums1 = {2,5,7,8};
//        int[] nums2 = {1,4,6};
//        merge(nums1, nums1.length, nums2, nums2.length);

//        if (validParanthesis("{}[]()")) {
//            System.out.println("1: is valid");
//        }
//        if (validParanthesis("{[()]}")) {
//            System.out.println("2: is valid");
//        }
//        if (validParanthesis("({{)}}")) {
//            System.out.println("3: is valid");
//        }

//        int[] arr = new int[]{5,3,1,1,4,5,2};
//        int[] result = removeDup(arr);
//        for (int i : result) {
//            System.out.println(i);
//        }

//        System.out.println(countPrimes(4));

//        int[] arr = {2,4,6,8,10};
//        movingAverage(arr, 3);

        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ls.stream().map(x -> x * 2).forEach(System.out::println);


    }
}
