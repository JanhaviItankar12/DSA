import java.util.*;

public class ReverseString {
    public static void main(String[] args){
        String str="Java";
        

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            stack.push(c);
        }

        
         
        
        StringBuilder str1=new StringBuilder();
        int n=stack.size();
        for(int i=0;i<n;i++){
            char c=stack.pop();
            
            str1.append(c);
        }

        System.out.println(str1.toString());
        
    }
}
