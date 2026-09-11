public class PaintHouse2 {

    public static int optimizedSolution(int cost[][],int k){
        int ans=Integer.MAX_VALUE;

        int prev[]=new int[k];

        //base case
        for(int i=0;i<k;i++){
            prev[i]=cost[0][i];
        }

        int n=cost.length;

        for(int i=1;i<n;i++){
            int curr[]=new int[k];

            //find min1 and min2;
            int min1=Integer.MAX_VALUE;
            int min2=Integer.MAX_VALUE;
            int minColor=-1;
            for(int j=0;j<k;j++){
                if(prev[j]<min1){
                    min2=min1;
                    min1=prev[j];
                    minColor=j;
                }
                else if(prev[j]<min2){
                    min2=prev[j];
                }
            }

            //now  color with given index
            for(int j=0;j<k;j++){
                if(minColor==j){  //prev got same color
                  curr[j]=cost[i][j]+min2;
                }
                else{
                    curr[j]=cost[i][j]+min1;
                }
            }

            prev=curr;
        }

        for(int i=0;i<k;i++){
            ans=Math.min(ans,prev[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int cost[][]={{100,200,400,500,300},
        {100,200,400,500,300},
        {100,200,400,500,300}
        };

        int k=cost[0].length;

        if (k==1 && cost.length>1){
           System.out.println(-1);
           return;
        }
         
        int n=cost.length;
        int dp[][]=new int [n][k];

        for(int i=0;i<k;i++){
            dp[0][i]=cost[0][i];
        }
        
        // O(n*K*K)
        for(int i=1;i<n;i++){
           
            for(int j=0;j<k;j++){
                dp[i][j]=cost[i][j];  //pick one color

                int min=Integer.MAX_VALUE;

                for(int m=0;m<k;m++){
                    if(m==j){
                        continue;   //skip same color in previous days
                    }
                    min=Math.min(min,dp[i-1][m]);
                }

                dp[i][j]+=min;

            }

        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }

        System.out.println(ans);

        //optimized a solution  -O(n*k)
        System.out.println(optimizedSolution(cost,k));




    }
}
