import java.util.*;

public class NextGreaterElement {
    public static void main(String args[]){
        int arr[]={1,3,2,4};
        int n=arr.length;

        //to store next greater element in stack
        Stack<Integer> st=new Stack<>();

        //res
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=n-1;i>=0;i--){

          if(st.isEmpty()){
            list.add(-1);
          }
          else{

            while(!st.isEmpty() && st.peek()<=arr[i]){
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
