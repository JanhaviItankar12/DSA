public class HouseRobber {
    public static void main(String args[]){
        int houses[]={2,1,1,2};

        int n=houses.length;
        
        //we have to rob no option
        if(n==1){
            System.out.println(houses[0]);
            return;
        }

        int dp[]=new int[n];

        dp[0]=houses[0];
        dp[1]=Math.max(houses[1],houses[0]);

        for(int i=2;i<n;i++){

            //there are two options
            int rob=houses[i]+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(rob,skip);
        }

        System.out.println(dp[n-1]);


    }
}
