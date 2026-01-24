import java.util.*;

public class MaximumElement {
    public static void main(String[] args){

        String queries[]={"1 98","1 67","2","3","1 56","3"};
        int n=queries.length;

        Stack<Integer> st=new Stack<>();
        Stack<Integer> maxSt=new Stack<>();

        for(int i=0;i<n;i++){

            if(queries[i].charAt(0)=='1'){
                int num=Integer.parseInt(queries[i].substring(2));
                st.push(num);

                if(maxSt.isEmpty() || num>=maxSt.peek()){
                    maxSt.push(num);
                }
            }
            else if(queries[i].charAt(0)=='2'){
                int num=st.pop();

                if(!maxSt.isEmpty() && num==maxSt.peek()){
                    maxSt.pop();
                }
            }
            else{
                System.out.println(maxSt.peek());
            }
        }



    }
}
