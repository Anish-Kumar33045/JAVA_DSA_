
import java.util.Stack; 



public class Reverse {
    public static String reverse (String str){
        Stack<Character> stack = new Stack<>(); // ?
        char[] chars = str.toCharArray();

        // push elements to stack
        for(char c : chars){
            stack.push(c);
        }

        // pop elements from stack
        for(int i=0 ; i<chars.length; i++){
            chars[i] = stack.pop();
        }

        return new String(chars);
    }
   public static void main(String[] args) {
    String str = "ABCD";
    System.out.println("BEfore reverse : "+str);
    System.out.println("after reverse : "+ reverse(str));
   } 
}
