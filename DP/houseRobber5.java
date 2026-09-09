public class houseRobber5 {

    public static void solveDP(int house[],int color[],int n){

        int dp[][]=new int[n][2];

        dp[0][0]=house[0];

        for(int i=1;i<n;i++){

            //not robbed
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);

            //robbed
            if(color[i]==color[i-1]){
                dp[i][0]=house[i]+dp[i-1][1];
            }
            else{
                dp[i][0]=house[i]+Math.max(dp[i-1][0],dp[i-1][1]);
            }
        }

        
        
        System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));
    }


    public static void optmizedSolution(int house[],int color[],int n){

        int robbed=house[0];
        int notRobbed=0;

        for(int i=1;i<n;i++){

            //not robbed the house
            int currNotRobbed=Math.max(robbed,notRobbed);

            //robbed
            int currRobbed=house[i];

            if(color[i]==color[i-1]){
                currRobbed+=notRobbed;
            }
            else{
                currRobbed+=Math.max(robbed,notRobbed);
            }

            notRobbed=currNotRobbed;
            robbed=currRobbed;

        }

        System.out.println(Math.max(robbed,notRobbed));
    }
    public static void main(String args[]){
        int house[]={1,4,3,5};
        int color[]={1,1,2,2};

        int n=house.length;

        //dp Solution
        solveDP(house,color,n);

        //optmized
        optmizedSolution(house,color,n);

        

    }
}
