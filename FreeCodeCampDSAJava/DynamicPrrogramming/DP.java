/*
 *  DP is  technique in which a complaex problem is solved by :-
 *  1) breaking it into smaller sub-problems
 *  2) Solving those sub-problems ans simply storing their results
 *  3) Re-use those stored results if sub-problems occurs/overlaps again.(Avoid solving sub problem again)
 *  4) Finally using the solns of smaller problems build up soln to complex problem
 * 
 *  Dynamic Programming and Recursion
 *  it mainly an optimization over recursion
 *  DP = recursion + Memorization
 *  
 *  Dp and Optimal SubStructure
 *  a given problem has Optimal SubStructure property if optimal soln of 
 *  given problem can be obtained by using the optimal solution of its sub-problems
 * 
 *  DP and overlapping Subproblems
 *  a given problem has Overlapping SSubproblems Property if soln of given
 *  problem is obtained by solving same subproblems multiple times
 * 
 *  two approach to solve DP
 * 1)  Bottom Up Approach
 *     it is also called as Tabulation Method
 *     the solns is build in tabular form by using solutions of smaller sub-problems iteratively and generating solutions to bigger sub-problems
 * 2) Top down Approach
 *    also called as Memoization
 *   we break large problem into multiple sub-problems
 *   each of sub problems are solved and solns are remembered
 *   if sub-problem is solved already then reuse the answer
 *   thus, it memorizes the soln of sub-problem to avoid recomputing the value if sub-problem is encountered again.
 *   
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DP {
    public int fib(int n){
        if(n==0 || n==1) return n;
        int left  = fib(n-1);
        int right = fib(n-2);
        return  left+right;
    }
    // soving without using recursion DP
    public int fib2(int n){ // by Bottom up approach
  int[] table = new int[n+1];  // as array starts from zero , the value of fib 5 will be stored in index 5 of array therefore size n+1 (here 6) 
   table[0] = 0;
   table[1] = 1;
   for(int i=2; i<=n; i++){
    table[i] = table[i-1] + table[i-2];
   }
   return table[n];
    }
    
    // top down approach DP
    // here we start fromindex 5 top index of array
    public int fib3(int[] memo,int n){
        if(memo[n] == 0){ // check if the num is encountered already
            if(n<2){
                memo[n] = n;
            } else{
                int left = fib3(memo,n-1);
                int right = fib3(memo,n-2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    // Maximum Sum Subarray (Kadane's Algorithm)
      public int maxSubArraySum(int[] arr){
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        for(int i=1; i< arr.length; i++){
            currentMax = currentMax + arr[i];
            if(currentMax < arr[i]){
                currentMax = arr[i];
            }
            if(maxSoFar < currentMax){
              maxSoFar = currentMax;
            }
        }
        return maxSoFar;
      }

      // two sum 
      // given an arr of integers, return indices of two numbers such that they add up to a specific target
      // {2,11,5,10,7,8} , target 9 , soln -> arr[0]+arr[4] = 2+7 = 9, return {0,4} indices
       public int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length ; i++){
           if(!map.containsKey(target - numbers[i])){
             map.put(numbers[i],i);
           } else{
            result[1] = i;
            result[0] = map.get(target-numbers[i]);
            return result;
           }
        }
          return result;
       }
          
       // two sum another approach
        public int[] twoSum2(int[] arr ,int target){
          Arrays.sort(arr);
          int left = 0;
          int right = arr.length-1;
          int[] result = new int[2];
          while(left< right){
            int sum = arr[left]+arr[right];
            if(sum == target){
              result[0] = arr[left];
              result[1] = arr[right];
              return result;
            }else if(sum<target){
              left++;
            }else{
              right--;
            }
          }
          return new int[0];
        }

        // subsequence
        // subsequence of string is a new string formed from the original string by deleting some or no characters without changing the order of remaining characters
        //  "ace" is subsequence of "abcde"
        //  "aec" is not subsequence of "abcde"
        public boolean isSubsequence(String str,String seq){
          int i=0;
          int j=0;
          while(i<str.length() && j<seq.length()){
            if(str.charAt(i)==seq.charAt(j)){
              j++;
            }
            i++;
          }
          return j== seq.length();
        }

        // first non repeating character problem
        /*
         * given str s , return index of irst non repeating character in it. if doesn't exist return -1, str -> lowerCase letters
         * 
         * ex-> str = "codeforcode"
         *      o/p = 4 first non repeating character is "f"
         * 
         * str = "aabb"
         * o/p = -1 doesn't have non repeating character
         */

         public int firstNonRepeatingCharacter(String str){
          Map<Character,Integer> map = new HashMap<>();
          char[] chars = str.toCharArray();
           
          for(char ch : chars){
            map.put(ch,map.getOrDefault(ch,0)+1); // get the value for key or set it as default
            // index 0 for r , when mapped key -> r & value is 0(default value) + 1 = 1 // +1 is done as its encountered once 
            // index 6 for r , key->r & value is 1(get value)  + 1 = 2 // now encountered two times 
          }

          for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            if(map.get(ch) ==1){ 
              return i;
            }
          }
           return -1;
         }

         // remove vowels from strings
         public String removeVowels(String str){
          Set<Character> vowels = Set.of('a','e','i','o','u');
          StringBuilder sb = new StringBuilder();

          char[]  chars = str.toCharArray();

          for(Character ch : chars){
             if(!vowels.contains(ch)){
               sb.append(ch);
             }
          }
          return sb.toString();
         }

          // reverse an interger 
          public long reverse(int number){ // long because on reversal if the number excced int range
            boolean isNegative = number<0;
            if(isNegative){
              number = number * -1;
            }
            long reverse = 0; 
            int lastDigit;
            while(number >0){
              lastDigit = number %10;
              reverse = reverse * 10 + lastDigit;
              number = number/10;
            }
            return isNegative ? reverse*-1 : reverse;
          }
         
          // remove all the occurrences of element from array
            public int removeElement(int[] nums,int val){
              int i=0;
              for(int j=0; j< nums.length; j++){
                if(nums[j] != val){
                  nums[i] = nums[j];
                  i++;
                }
              }
              return i;
            }
            
            public void printArr(int[] arr){
              for(int i=0; i<arr.length; i++){
                System.out.print(arr[i]+" ");
              }
            }

       // remove duplicates from sorted Array
       /*
        *  using two ptrs here i,j
          i -> slow ptr -> removes the duplicate
          j -> fast ptr -> compares the duplicate and traverse array

        */
       public int removesDuplicates(int[] nums){
        int i=1;
        for(int j=1;j<nums.length;j++){
          if(nums [j-1] != nums[j]){ // unique element found then,
            nums[i] = nums[j];
          }
        }
        return i;
       }

      // three sum problem
       /*
        *  sort the array
           three ptrs i,j,k

        */

         public void threeSum(int[] arr,int target){
            for(int i=0; i<arr.length - 2;i++){
              int j=i+1;
              int k = arr.length;
              while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==target){
                  System.out.println(arr[i]+","+arr[j]+","+arr[k]);
                  j++;
                  k--;
                }
                else if(sum<target){
                  j++;
                }
                else{
                  k--;
                }
              }
            }
         }

        //  Sliding window Maximum
        /*
         *   
         */
       public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=arr.length; i>=0;i--){
          if(!stack.isEmpty()){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
              stack.pop(); //arr[stack.peek()] <= arr[i] then, arr[i] will be greater element to the left side of array
   
             } 
          }
          if(stack.isEmpty()){
            result[i] = arr.length;
          } else{
            result[i] = stack.peek();
          }
          stack.push(i);
        }
        return result;
       }

      public List<Integer> maxSlidingWindow(int[]arr , int k){
        int[] ngeArr = nextGreaterElement(arr);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=arr.length - k;i++){
         int j=i;
         while(ngeArr[j] < i+k){
          j=ngeArr[j];
         }
         result.add(arr[j]);
        }
        return result;
       }

      //  maximum sum of subArr size k // sliding window
      public int sumofSubArr(int[] arr,int k){
        int max = Integer.MIN_VALUE;
        
        for(int i=0 ; i<arr.length - 2; i++){
             int sum = 0 ;
              int j=i;
              while(j<i+k){
                 sum = sum + arr[j];
                 j++;
              }
              if(sum > max){
                max = sum;
              }
           } 
          
        return max;
      }

      // Longest sub string without repeating characters

      // Binary is symmetric or not ??
      private class TreeNode{
        private int val;
       public TreeNode left;
       public TreeNode right;
      }
      public boolean isSymmetric(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
          TreeNode n1 = stack.pop();
          TreeNode n2 = stack.pop();
          if(n1 == null && n2 == null) continue;
          if(n1 == null || n2 == null ||n1.val != n2.val) return false;

          stack.push(n1.left);
          stack.push(n2.right);
          stack.push(n1.right);
          stack.push(n2.left);
        }
        return true;
      }

         
    public static void main(String[] args) {
        DP obj = new DP();
        // System.out.println("Fib of six using recursion is : "+obj.fib(6));
        // System.out.println("Fib of six using table method is : "+obj.fib2(6));
        // System.out.println("Fib of six using memoization method is : "+obj.fib3(new int[6+1],6));
        
        // int[] arr = new int[] {4,3,-2,6,-12,7,-1,6};
        // System.out.println("MaxSoFar in arr is : "+obj.maxSubArraySum(arr));

        // int[] num = new int[] {2,11,5,10,7,8};
        // int[] result = obj.twoSum(num,9);
        // int[] result2 = obj.twoSum2(num,9);

        // System.out.println("the two indices are : "+result[0] +" and "+result[1]);
        // System.out.println("the two2 values are : "+result2[0] +" and "+result2[1]);
        // System.out.println("isSubsequence : ");
        // System.out.println(obj.isSubsequence("abcde", "ace"));
        // System.out.println(obj.isSubsequence("abcde", "aec"));

        // System.out.println("first non repeating char : "+obj.firstNonRepeatingCharacter("racecars"));

        // System.out.println();
        // System.out.println("remove vowels from word 'ice cream' : "+obj.removeVowels("ice cream"));
        // System.out.println();
        
        // int[] arr2 = new int[] {1,2,3,2,4,2,5,2};
        // System.out.println("before removing element : ");
        // obj.printArr(arr);
        // obj.removeElement(arr2, 2);
        // System.out.println("after removing element : ");
        // obj.printArr(arr);
        // System.out.println();
        int[] arr3 = new int[]{2,7,3,5,8,1};
        System.out.println("max of sub Arr :"+obj.sumofSubArr(arr3, 3));
    }
}
