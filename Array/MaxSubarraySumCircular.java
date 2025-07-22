public class MaxSubarraySumCircular {
    public static void main(String[] args) {
        int arr[]={1,2,-3,-4,5};
        int n=arr.length;
        int currMin=arr[0];
        int currMax=arr[0];
        int maxSum=arr[0];
        int minSum=arr[0];
        int totalSum=arr[0];
       
        
        for(int i=1;i<n;i++){
            
        // srep1:find normal maxSubarray sum through kadane algo
        currMax=Math.max(arr[i],currMax+arr[i]);
        maxSum=Math.max(maxSum,currMax);
        
        // step2:find normal minSubarray sum through kadane
        currMin=Math.min(arr[i],currMin+arr[i]);
        minSum=Math.min(minSum,currMin);
        
        // step3:find total sum of array
        totalSum+=arr[i];
        }
        
        if(maxSum<0){
           System.out.println(maxSum);
        }
        
        int ans= Math.max(maxSum,totalSum-minSum);
        System.out.println(ans );
    }
}
