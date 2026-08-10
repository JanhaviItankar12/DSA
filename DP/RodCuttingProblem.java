public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[]={1, 5, 8, 9, 10, 17, 17, 20};
        int n=price.length;

        int dp[]=new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int maxValue=Integer.MIN_VALUE;

            for(int j=1;j<=i;j++){
                maxValue=Math.max(maxValue,price[j-1]+dp[i-j]);
            }
            dp[i]=maxValue;
        }

        System.out.println("Maximum Profit after rod cutting: "+dp[n]);

        int a=Math.
    }
}
