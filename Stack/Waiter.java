import java.util.*;

public class Waiter {

    public static void main(String[] args){
         int q=3;
         int arr[]={2,3,4,5,6,7};
         int n=arr.length;

         //list of all primes numbers i.e q for q iterations
         List<Integer> primes=new ArrayList<>();
         int num=2;

         while(primes.size()<q){
            boolean isPrime=true;
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    isPrime=false;
                    break;
                }
            }

            if(isPrime){
                primes.add(num);
            }
            num++;
         }

         Stack<Integer> st=new Stack<>();

         for(int i=0;i<n;i++){
            st.push(arr[i]);
         }

         
         List<Integer> ans=new ArrayList<>();

         for(int i=0;i<q;i++){

            Stack<Integer> A=new Stack<>();
            Stack<Integer> B=new Stack<>();
            
            //moving lements to correct stacks
            int ithPrime=primes.get(i);
            while(!st.isEmpty()){
                if(st.peek()%ithPrime==0){
                    B.push(st.pop());
                }
                else{
                    A.push(st.pop());
                }
            }

            

            //moving elements to ans from B stack
            while(!B.isEmpty()){
                ans.add(B.pop());
            }

            st=A;

         }

         while(!st.isEmpty()){
            ans.add(st.pop());
         }

         System.out.println(ans);




    }
    
}
