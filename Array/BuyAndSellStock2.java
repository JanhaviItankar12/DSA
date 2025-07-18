public class BuyAndSellStock2 {
    public static void main(String[] args) {
        int arr[]={4,2,2,4};
        int n=arr.length;
        int maxProfit=0;
         
        // TC=o(N)
        // step1:find the stock that can be sold in future
        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                maxProfit+=(arr[i+1]-arr[i]);
            }
        }

        System.out.println(maxProfit);
    }
}
