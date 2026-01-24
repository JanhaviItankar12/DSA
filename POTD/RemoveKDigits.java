import java.util.*;

public class RemoveKDigits {
    public static void main(String[] args) {
        String s="1000000001";
        int k=5;
        int n=s.length();


        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){

            char ch=s.charAt(i);
            int num=ch-'0';
            
            
            while(!st.isEmpty() && k>0 && st.peek()>num){
                st.pop();
                k--;
            }
            
            st.push(num);

        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        StringBuilder res=new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        res.reverse();

        

        StringBuilder newStr=new StringBuilder();
        
        int j=0;
        while(j<res.length() && res.charAt(j)=='0'){
            j++;
        }

        for(int i=j;i<res.length();i++){
            newStr.append(res.charAt(i));
        }

        if(newStr.length()==0){
            newStr.append(0);
        }

        System.out.println(newStr);

        
    }
}
