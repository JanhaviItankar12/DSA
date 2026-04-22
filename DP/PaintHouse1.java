public class PaintHouse1 {
    public static void main(String[] args) {
        int cost[][]={{100,200,400},
        {300,200,400},
        {200,240,500}};

        int n=cost.length;

        int dp[][]=new int[n][3];

        //base case
        int prevRed=cost[0][0];  //red color
        int prevBlue=cost[0][1];  //blue color
        int prevGreen=cost[0][2];  //green color

        for(int i=1;i<n;i++){

            //red color
            dp[i][0]=cost[i][0]+Math.min(prevBlue,prevGreen);

            //blue color
            dp[i][1]=cost[i][1]+Math.min(prevRed,prevGreen);

            //red color
            dp[i][2]=cost[i][2]+Math.min(prevRed,prevBlue);

            prevRed=dp[i][0];
            prevBlue=dp[i][1];
            prevGreen=dp[i][2];
        }

        System.out.println(Math.min(prevRed,Math.min(prevBlue,prevGreen)));
        
    }
}
