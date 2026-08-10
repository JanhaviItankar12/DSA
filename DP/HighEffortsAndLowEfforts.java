public class HighEffortsAndLowEfforts {

    public static int dpApproach(int h[],int l[]){

        int n=h.length;

        int dp[][]=new int[n][3];

        //intial state
        dp[0][0]=0;  //no task
        dp[0][1]=l[0];    //low task
        dp[0][2]=h[0];    //high task-taken from first day

        for(int i=1;i<n;i++){
           
            //no task
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));

            //low task
            dp[i][1]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]))+l[i];

            //high task
            dp[i][2]=dp[i-1][0]+h[i];
        }

        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
    }

    public static int optimizedDP(int h[],int l[]){

        int n=h.length;

        int noTask=0;
        int lowTask=l[0];
        int highTask=h[0];

        for(int i=1;i<n;i++){
            
            int prevMax=Math.max(noTask,Math.max(lowTask,highTask));
            
            int tempNoTask=noTask;

            noTask=prevMax;
            lowTask=prevMax+l[i];
            highTask=tempNoTask+h[i];



        }

        return Math.max(noTask,Math.max(lowTask,highTask)); 
    }
    public static void main(String args[]){
        int h[]={2,8,1};
        int l[]={1,2,1};

        int ans1=dpApproach(h,l);
        System.out.println(ans1);

        int ans2=optimizedDP(h,l);
        System.out.println(ans2);
    }
}
