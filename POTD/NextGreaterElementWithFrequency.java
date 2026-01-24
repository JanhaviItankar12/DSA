
import java.util.Stack;

public class NextGreaterElementWithFrequency {
    
    public static void main(String args[]){
        int arr[]={5,1,5,6,6,6};
        int n=arr.length;
        int res[]=new int[n];

        int large=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }

        int freq[]=new int[large+1];

        for(int i=0;i<n;i++){
            freq[arr[i]]++;
        }

        //bruteforce approach
        // for(int i=0;i<n;i++){

        //     int fre=freq[arr[i]];

        //     int j=i+1;
        //     int index=-1;
        //     while(j<n){
        //        if(fre<freq[arr[j]]){
        //           fre=freq[arr[j]];
        //           index=arr[j];
        //        }
        //        j++;
        //     }

        //     res[i]=index;



        // }

        //optimal
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && freq[arr[i]]>freq[arr[st.peek()]]){
                res[st.pop()]=arr[i];
            }

            st.push(i);

        }

        while(!st.isEmpty()){
            res[st.pop()]=-1;
        }

        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }






    }
}
