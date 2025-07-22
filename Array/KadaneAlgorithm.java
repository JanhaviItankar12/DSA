public class KadaneAlgorithm {
    public static void main(String[] args) {
        int arr[]={-3 ,-2 ,-6 ,-1, -7 ,-4};
        int n=arr.length;
        int ans=arr[0];
        int currentSum=arr[0];
       
        
        for(int i=1;i<n;i++){
            
            currentSum=Math.max(arr[i],currentSum+arr[i]);
            ans=Math.max(ans,currentSum);
        }
       
        System.out.println(ans);
    }
}
