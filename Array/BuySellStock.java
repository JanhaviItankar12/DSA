public class BuySellStock {
    public static void main(String[] args) {
        int arr[]={100,180,260,310,40,535,695};
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
        
        // if stock prices is in dec order
        if(bestBuy==arr[n-1]){
            System.out.println("No Profit");
        }
        else{
        // find selling value
        int sellDayValue=maxProfit+bestBuy;
        for(int i=0;i<n;i++){
            // selling day
            if(arr[i]==sellDayValue){
                System.out.println("Sell on that day:"+i);
            }
            // buy day
            else if(arr[i]==bestBuy){
                System.out.println("Buy on that day:"+i);
            }
        }
    }
    }
}
