
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int arr[]={3,7,8,2,4};
        int n=arr.length;

        Stack<Integer>st=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=n-1;i>=0;i--){

            if(st.isEmpty()){
                list.add(-1);
            }
            else{

                while(!st.isEmpty() && st.peek()>=arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                 list.add(-1);
                }
                else{
                    list.add(st.peek());
                }

                
            }

            st.push(arr[i]);
        }

        Collections.reverse(list);
        System.out.println(list);


    }
}
