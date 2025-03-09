
import java.util.Scanner;
import java.util.Stack;



public class ValidParenthesis {
    boolean isvalid(String s){

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
           if(c == '(' || c == '[' || c=='{'){
            stack.push(c);
           }
        
          else{
           if(stack.isEmpty()){
            return false;
           }
           else{
            char top = stack.peek();
            if(c==')'&& top == '(' || c=='}'&& top == '{' ||c==']'&& top == '[' ){
                stack.pop();
            }
            else {
                return false;
            }
           }
         } 
        }
        return stack.isEmpty();
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ValidParenthesis obj = new ValidParenthesis();
        String s = in.next();
       Boolean res = obj.isvalid(s);
       System.out.println(res);
    }
}
