import java.util.*;

public class stockSpanProblem {

    public static void optimal(int arr[],int n){

        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int i=0;
        
        while(i<n){

            if(stack.isEmpty()){
               list.add(i+1);
               stack.push(i) ;
               i++;
            }
            else if(arr[stack.peek()]>=arr[i]){
                list.add(i-stack.peek());
                stack.push(i);
                i++;
            }
            else{
                stack.pop();
            }
        }

        System.out.println(list);




    }
    public static void main(String[] args){

        int arr[]={3,7,7,6,1,2,6,3,7};

        int n=arr.length;

        optimal(arr,n);
        ArrayList<Integer> list=new ArrayList<>();
        
        //brute force-o(n^2)
        for(int i=0;i<n;i++){
            
            int j=i;
            int count=0;
            while(j>=0){
              if(arr[i]>=arr[j]){
               count++;
              }
              else{
                break;
              }
              j--;
            }

            list.add(count);

        }

       
        System.out.println(list);
        
    }
}
