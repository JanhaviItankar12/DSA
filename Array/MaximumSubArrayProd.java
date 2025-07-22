

public class MaximumSubArrayProd {
    public static void main(String[] args) {
        int arr[]={-2, 6, -3, -10, 0, 2};
        int n=arr.length;
        
        int ans=arr[0];

        //brute force approach- T(C)=O(n^2)
        for(int i=0;i<n;i++){
            int maxProd=1;
            for(int j=i;j<n;j++){
                maxProd*=arr[j];
                ans=Math.max(ans, maxProd);
            }
            
        }
        System.out.println(ans);
    }
}
