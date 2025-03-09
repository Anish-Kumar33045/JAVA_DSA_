
import java.util.Stack;



public class NEXTgreater {
    public int[] NextGreater(int arr[]){
     int[] result = new int[arr.length];
     Stack<Integer> stack = new Stack<>();

     for(int i = arr.length-1; i>=0;i--){
      if(!stack.isEmpty()){
        while(!stack.isEmpty() && stack.peek() <= arr[i]){
            stack.pop();
        }
      }
      
      if(stack.isEmpty()){
        result[i] = -1;
      }
      else{
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
     }
       return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,7,3,4,8,1}; 
       NEXTgreater obj = new NEXTgreater();
       int arr1[] = obj.NextGreater(arr);
       for (int i = 0; i < arr1.length; i++) {
           System.out.println(arr1[i]+" ");
       }
    }
}
