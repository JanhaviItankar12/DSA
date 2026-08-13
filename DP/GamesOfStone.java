public class GamesOfStone {

    public static boolean dpApproach(int n){

        if(n<=0){
            return false;
        }
       
        boolean dp[]=new boolean[n+1];

        dp[0]=false;

        if(n>=1){
            dp[1]=true;
        }

         if(n>=2){
            dp[2]=false;
        }
         if(n>=3){
            dp[3]=true;
        }

         if(n>=4){
            dp[4]=true;
        }

        for(int i=5;i<=n;i++){
            dp[i]=!dp[i-4]  || !dp[i-3]  || !dp[i-1];
        }

        return dp[n];
    }

    public static boolean optmizedApproach(int n){

        if(n<=0){
            return false;
        }

        boolean dp1=true;
        boolean dp2=false;
        boolean dp3=true;
        boolean dp4=true;

        for(int i=5;i<=n;i++){
            boolean curr=!dp1 || !dp2  ||!dp4;

            dp1=dp2;
            dp2=dp3;
            dp3=dp4;
            dp4=curr;
        }

        return dp4;
    }

    public static boolean moreOptmizedApproach(int n){

        if(n==2){
            return false;
        }

        return n%7!=0 && n%7!=2;


    }
    public static void main(String[] args) {
       
        int n=7;
        
        //dp approach
        System.out.println(dpApproach(n));

        // optimized dp approach -O(n);
        System.out.println(optmizedApproach(n));
        
        //more optmized approch - O(1)
        System.out.println(moreOptmizedApproach(n));

        

        
    }
}