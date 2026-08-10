public class MatrixChain{
   
    public static int findMinCost(int matrix[],int n){
        int dp[][]=new int[n][n];

        for(int gap=2;gap<n;gap++){
            for(int i=1;i<n-gap+1;i++){
                int j=i+gap-1;
                dp[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int cost=dp[i][k]+dp[k+1][j]+matrix[i-1]*matrix[k]*matrix[j];
                    if(cost<dp[i][j]){
                        dp[i][j]=cost;
                    }
                }
            }
        }

        return dp[1][n-1];
    }

    public static void main(String args[]){
        int matrix[]={40,30,60,20,89};
        int n=matrix.length;
        
        System.out.println("MinCost of Matrix chain multilication: "+findMinCost(matrix,n));
    }
}