public class trianglePolygon {

    
    public static int minScoreTriangulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];

        for(int gap=2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;

                for(int k=i+1;k<j;k++){
                    int cost=dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k];
                    dp[i][j]=Math.min(dp[i][j],cost);
                }

            }
        }
        
        return dp[0][n-1];



    }
    public static void main(String[] args) {
        int arr[]={1,3,1,4,1,5};

        System.out.println("Minimum triangulation cost:"+minScoreTriangulation(arr));

    }
}
