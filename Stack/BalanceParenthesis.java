import java.util.*;

public class BalanceParenthesis {


     public static boolean isBalanced(String s){
        // code here
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
           
            if(s.charAt(i)== '{' || s.charAt(i)== '[' || s.charAt(i)== '('){
               stack.push(s.charAt(i));
            }
            else{

                if(stack.isEmpty())  return false;
                else{

                    if(s.charAt(i)== '}' && stack.pop()!='{'  || s.charAt(i)== ']' && stack.pop()!='[' || s.charAt(i)== ')' && stack.pop()!='('){
                      return false;
                    }
                }
            }
        }
           
        return true;
    }
        
    public static void main(String[] args) {
        String s="{}{{[]}}";

        boolean res=isBalanced(s);
        System.out.println(res);
    }
}
