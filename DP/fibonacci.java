
import java.util.Arrays;

public class fibonacci{

    public static int fibonacci(int n){

         if(n<=1){
            return n;
         }

         return fibonacci(n-1)+fibonacci(n-2);


    }

    public static int memoizedDP(int dp[],int n){

        if(n<=1){
            return dp[n]=n;
        }

        if(dp[n]!=-1){
           return dp[n];
        }

        return memoizedDP(dp, n-1)+memoizedDP(dp,n-2);
    }

    public static int tabuloDP(int dp[],int n){

        if(n==0){
            return 0;
        }

        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
    public static void main(String args[]){
         
        int n=6;

        //normal recursion  -top down approach
        System.out.println(fibonacci(n));

        //memoized DP
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memoizedDP(dp,n));

        //tabuloDPb  -bottom up approach
        System.out.println(tabuloDP(dp,n));
    }
}