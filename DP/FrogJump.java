public class FrogJump {
    public static void main(String args[]){

        int h[]={30,20,50,10,40};
        int n=h.length;

        //base case
        if(n==1){
            System.out.println(0);
        }

        int dp[]=new int[n];

        dp[0]=0;
        dp[1]=Math.abs(h[0]-h[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1]+Math.abs(h[i]-h[i-1]),dp[i-2]+Math.abs(h[i]-h[i-2]));
        }

        System.out.println(dp[n-1]);


    }
}
