package com.longyi.csjl.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author ly
 * @Description TODO
 * @date 2020/8/13 20:01
 */
public class LeetCodeTest {
  public static void main(String[] args) {
//      int[] ints = twoSum(new int[]{1, 2, 3, 4}, 5);
//      int[] result = twoSumRight(new int[]{1, 2, 3, 4}, 5);
//      System.out.println(Arrays.toString(ints));
//      System.out.println(Arrays.toString(result));
//      int reverse = reverse(12323);
//      int reverse2= reverse(-4512323);
//      int reverse3= reverse(Integer.MAX_VALUE-1);
//      System.out.println(reverse2);
//      System.out.println(reverse);
//      System.out.println(reverse3);
//        isPalindrome(123321);
//      int res = romanToInt("III");
//      int res1 = romanToInt("IV");
//      int res2 = romanToInt("LVIII");
//      int res4 = romanToInt("XL");
//    System.out.println(res+" "+res1+" "+res2+" "+res4);
//      String[] str={"abcfge","ge"};
//      String s = longestCommonPrefix(str);
//      System.out.println(s);
//      isValid("{[]}");
      ListNode<Integer> listNode=new ListNode<>(22);
      ListNode<Integer> listNode1=new ListNode<>(4);
      listNode.next=listNode1;

      ListNode<Integer> listNode3=new ListNode<>(3);
      ListNode<Integer> listNode4=new ListNode<>(54);
      listNode3.next=listNode4;

      ListNode node = mergeTwoLists(listNode, listNode3);
       System.out.println(node);
  }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumRight(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
          if(map.containsKey(target-nums[i])){
              return new int[]{map.get(target-nums[i]),i};
          }
          map.put(nums[i],i);
      }
      return null;
    }

    /**
     * 整数反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        StringBuilder sb=new StringBuilder();
        char[] charArray=String.valueOf(x).toCharArray();
        for(int i=charArray.length-1;i>=0;i--){
            if(charArray[i]=='-'){
                sb=new StringBuilder("-").append(sb.toString());
            }else{
                sb.append(charArray[i]);
            }
        }
        if(Long.valueOf(sb.toString())<Integer.MIN_VALUE){
            return 0;
        }
        if(Long.valueOf(sb.toString())>Integer.MAX_VALUE){
            return 0;
        }
        return Integer.valueOf(sb.toString());
    }


    /**
     * 回文数算法
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int reversedNumb=0;
        while (x>reversedNumb){
            reversedNumb=reversedNumb*10+x%10;
            x/=10;
        }
        return x==reversedNumb || x==reversedNumb/10;
    }


    private static final Map<String,Integer> map=new HashMap(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
    }};


    public static int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int sum=0;
        for (int i=0;i<charArray.length;i++) {
            Integer preValue = map.get(String.valueOf(charArray[i]));
            if(i<charArray.length-1){
                Integer currValue =map.get(String.valueOf(charArray[i+1]));
                if(preValue<currValue){
                    sum-=preValue;
                }else{
                    sum+=preValue;
                }
            }else{
                sum+=preValue;
            }
        }
        return sum;
    }

    /**
     * 取公共字符串
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix( String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);

    }





    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 合并两个连表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}    
   