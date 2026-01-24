import java.util.*;

public class SlidingWindowMaximum {
    public static void optimal(int arr[],int n,int k){
        
        Deque<Integer> dq=new ArrayDeque<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        //ananylse first window
        for(int i=0;i<k;i++){
            
            //remove elements that not would be possible ans
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();   
            }

            dq.addLast(i);
        }

        for(int i=k;i<n;i++){
            
            //ans-maximum of previous window
            res.add(arr[dq.peekFirst()]);

            //check elements present in dq are the part of current window or not
            while(!dq.isEmpty()  &&  dq.peekFirst()<=i-k){
                dq.removeFirst();
            }

            //now add elements that are part of our  curr window and would not be future ans
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }

            dq.addLast(i);
        }

        res.add(arr[dq.peekFirst()]);

        System.out.println(res);



    }


    public static void main(String[] args){

        int k=3;

        int arr[]={1,2,3,1,4,5,2,3,6};
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<=n-k;i++){
           
            int m=i;
            int p=i+k;
            int max=arr[m];

            while(m<p){
               if(arr[m]>max){
                max=arr[m];
               }
               m++;
            }

            res.add(max);



        }

        // System.out.println(res);

        optimal(arr,n,k);

    }
}
