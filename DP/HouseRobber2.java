public class HouseRobber2 {

    public static int rob(int houses[],int s,int e){

        int prev1=houses[s];
        int prev2=Math.max(prev1,houses[s+1]);

        for(int i=s+2;i<=e;i++){

            int rob=houses[i]+prev1;
            int skip=prev2;

            prev1=prev2;
            prev2=Math.max(rob,skip);
        }

        return prev2;
    }
    public static void main(String args[]){

        int houses[]={2,1,1,2,4};

        int n=houses.length;

        if(n==1){
            System.out.println(houses[0]);
            return;
        }

        if(n==2){
            System.out.println(Math.max(houses[0],houses[1]));
            return;
        }

        //cases
        int case1=rob(houses,0,n-2);  //excluded last house
        int case2=rob(houses,1,n-1);  //excluded first house

        System.out.println(Math.max(case1,case2));
    }
}
