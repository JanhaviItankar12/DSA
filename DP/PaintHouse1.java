public class PaintHouse1 {
    public static void main(String[] args) {
        int cost[][]={{100,200,400},
        {300,200,400},
        {200,240,500}};

        int n=cost.length;

        int dp[][]=new int[n][3];

        //base case
        dp[0][0]=cost[0][0];  //red color
        dp[0][1]=cost[0][1];  //blue color
        dp[0][2]=cost[0][2];  //green color

        for(int i=1;i<n;i++){

            //red color
            dp[i][0]=cost[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);

            //blue color
            dp[i][1]=cost[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);

            //red color
            dp[i][2]=cost[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
        }

        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));
        
    }
}
