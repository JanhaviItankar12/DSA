public class PaintHouseNotConsective3 {
    public static void main(String[] args) {
        
        int cost[][] = { { 100, 200, 400},
                { 100, 200, 400},
                { 100, 200, 400},
                {100,200,400}
        };

        int k = cost[0].length; // no of colors
        int n = cost.length; // no of houses

        int dp[][][]=new int[n][k][3];

        //base case
        for(int i=0;i<k;i++){
            dp[0][i][1]=cost[0][i];  //1-count
            dp[0][i][2]=Integer.MAX_VALUE;  //2-count
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){

                //same color
                dp[i][j][2]=dp[i-1][j][1]+cost[i][j];

                //diffrent color
                int best=Integer.MAX_VALUE;

                for(int m=0;m<k;m++){
                    if(m!=j){
                        best=Math.min(best,Math.min(dp[i-1][m][1],dp[i-1][m][2]));
                    }
                }

                dp[i][j][1]=cost[i][j]+best;
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ans=Math.min(ans,Math.min(dp[n-1][i][1],dp[n-1][i][2]));
        }


        System.out.println(ans);
    }
}
