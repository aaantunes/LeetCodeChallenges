package main.java.ca.jrvs.challenges;

import java.util.*;

public class main {

    public static int fibIterative(int n){
        if (n < 2) return n;

        int first = 0, second = 1, next = 1;
        for (int i=2; i < n; i++){
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }

    public static int[] fibSeqDynamicProgramming(int n) {
        int[] fibArr = new int[n];
        fibArr[0] = 1;
        fibArr[1] = 1;
        if (n < 2){
            return fibArr;
        }
        for (int i = 2; i < n; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr;
    }

    public static int fibRecursive(int n){
        if (n <= 1){
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static char[] dupChar(String s){
        Set<Character> chars = new HashSet<>();
        String dups = "";

        for (char c : s.toCharArray()){
            if (chars.contains(c)){
                dups += c;
                chars.remove(c);
            } else {
                chars.add(c);
            }
        }
        System.out.println(dups);
        return dups.toCharArray();
    }

    public static String reverseString(String input){

        String[] strings = input.split("\\s");

        int i=0, j = strings.length - 1;
        while(i < j) {
            String tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
            i++;
            j--;
        }

        return String.join(" ", strings);
    }

    public static boolean validPalindrome(String isPalindrome) {
        String string = isPalindrome.toLowerCase().replaceAll("[^a-z0-9]", "");
        int length = string.length();

        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String input){
        String s = input.replaceAll("[^A-Za-z0-9]","");
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sMap = new Hashtable<>();
        for (Character c : s.toCharArray()){
            if (sMap.containsKey(c)){
                sMap.replace(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()){
            if (sMap.containsKey(c)){
                sMap.replace(c, sMap.get(c) - 1);
                if (sMap.get(c) == 0){
                    sMap.remove(c);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    //Best performance
    public static boolean isAnagramIntArr(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
        }

        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

    public static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(arr[i],i);
        }
        throw new IllegalArgumentException("No twoSum solution for given parameters");
    }

    public static int missingNum(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            int expected = nums[i - 1] + 1;
            if (nums[i] != expected) {
                return expected;
            }
        }
        return -1;
    }

    public static int findDupicate(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        HashSet<Integer> map = new HashSet<>();
        for (int i : nums) {
            if (map.contains(i)){
                return i;
            } else {
                map.add(i);
            }
        }
        return -1;
    }

    public static int[] findLargestAndSmallest1(int[] arr) {
        Arrays.sort(arr);
        int[] result = new int[2];
        result[0] = arr[0];
        result[1] = arr[arr.length - 1];
        return result;
    }


    public static int[] findLargestAndSmallest2(int[] arr){

        int smallest = arr[0];
        int largest = arr[0];

        for (int i : arr){
            if (i < smallest){
                smallest = i;
            } else if (i > largest){
                largest = i;
            }
        }
        return new int[]{smallest,largest};
    }

    public static int[] swapTwoNums(int[] arr){
        int a = arr[0];
        int b = arr[1];

        //swap
        a = a + b;
        b = a - b;
        a = a - b;

        return new int[]{a,b};
    }

    public static boolean isNumericRegex(String s){
        return s.matches("\\d*");
    }

    public static String reverseWords(String s){
        String[] strings = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--){
            sb.append(strings[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void printLetterAndNum(String s) {

        for (char c : s.toLowerCase().toCharArray()){
            int num = c - 96;
            System.out.println(c + "" + num);
        }
    }

    public static int binarySearchIterative(int[] arr, int t){
        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int m = l + (r-l)/2;
            if (t == arr[m]){
                return m;
            } else if (t < arr[m]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int t, int l, int r){
        if (l > r) {
            return -1;
        }

        int m = l + ((r-l)/2);
        if (t == arr[m]){
            return m;
        }
        else if (t < arr[m]){
            return binarySearchRecursive(arr, t, l, m - 1);
        } else {
            return binarySearchRecursive(arr, t, m + 1, r);
        }
    }

    public static boolean rotateString(String A, String B){
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static String reverseStrByK(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }


    public static void main(String[] args) {


//        int[] arr = new int[]{1,2,3,4,5};
//        System.out.println(binarySearchRecursive(arr, 5, 0, arr.length - 1));
//        System.out.println(binarySearchIterative(arr, 5));

//        int[] arr = {1, 2, 3, 5, 6, 8, 11};
//        Arrays.stream(arr).forEach(s -> System.out.println(s));

//        Object[] array = new Object[]{"Andre",5};
//        Object[] arrayShort = {"Andre",5};

//        if (isNumericRegex("1232")){
//            System.out.println("true");
//        }

//        int[] arr = {1,0,7,2,3,5};
//        int[] result = twoSum(arr, 5);
//        for (int i: result){
//            System.out.println(i);
//        }

//        missingNum(arr);

//        if (validPalindrome("A man, a plan, a canal: Panama")){
//            System.out.println("true");
//        }

//        if (isPalindrome("abcba")) {
//            System.out.println("YES, I AM");
//        }

        if (isAnagram("anagram", "nagaram")) {
            System.out.println("is Anagram");
        } else {
            System.out.println("is not anagram");
        }

//
//        int[] arr = {-1, -2, -3, -4, -5};
//        int[] result = twoSum(arr, -8);

//        System.out.println(result[0] + "," + result[1]);

//        int[] arr = {1,2,3,4,5};
//        System.out.println(missingNum(arr));

//        int[] arr = new int[]{1,6,2,3,4,6,5};
//        System.out.println(findDupicate(arr));

//        int[] result = findLargestAndSmallest(new int[]{3,4,7,3,9,6});
//        for (int i : result) {
//            System.out.println(i);
//        }

//        int[] fib = fibSeqDynamicProgramming(8);
//        for (int i :
//             fib) {
//            System.out.println(i);
//        }

//

//        System.out.println(reverseString("Andre is a really cool dude"));

//        for (int i: swapTwoNums(new int[]{1,2})){
//            System.out.println(i);
//        }

//        System.out.println(fibIterative(8));
//        System.out.println(fibRecursive(5));

//        System.out.println(reverseWords("Andre is da best"));

//        dupChar("aaabccadeff");

//        printLetterAndNum("abcde");

//        if(isAnagramMap("aacc", "ccac")){
//            System.out.println("IS ANAGRAM");
//        } else {
//            System.out.println("is not anagram");
//        }


    }
}
