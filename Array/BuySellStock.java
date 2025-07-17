public class BuySellStock {
    public static void main(String[] args) {
        int arr[]={7,6,4,3,1};
        int n=arr.length;
        int maxProfit=0;

        // first day-only buy
        int bestBuy=arr[0];
         
        // step1:traverse array
        for(int i=1;i<n;i++){
            // it creates profit-
            if(arr[i]>bestBuy){
             maxProfit=Math.max(maxProfit, arr[i]-bestBuy);
            }
            else{
                // this aplies only when arr[i]<bestBuy
                bestBuy=Math.min(bestBuy, arr[i]);
            }
        }
        System.out.println(maxProfit);
    }
}
