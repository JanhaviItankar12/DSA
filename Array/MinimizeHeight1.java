import java.util.Arrays;

public class MinimizeHeight1 {
    public static void main(String[] args) {
        int arr[]={1, 8 ,10, 6 ,4, 6 ,9 ,1};
        int k=7;
        // code here
        int n=arr.length;
        
        // step1:sort
        Arrays.sort(arr);
        
        // step2:calculate max diff
        int ans=arr[n-1]-arr[0];
        
        int small=arr[0]+k;
        int big=arr[n-1]-k;  //now cannot do this function again
        
        // for edge case of small>big
        if(small>big){
            int temp=small;
            small=big;
            big=temp;
        }
        
        for(int i=1;i<n;i++){
            
            // for negative terms-for minimze height2
            if((arr[i]-k)>0) continue;

            int min=Math.min(small,arr[i]-k);
           
            int max=Math.max(big,arr[i-1]+k);
           
           
            ans=Math.min(ans,(max-min));
        
        }
        System.out.println(ans);
    }
}
