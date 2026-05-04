// You are given an even integer n representing the number of houses arranged in a straight line, and a 2D array cost of size n x 3, where cost[i][j] represents the cost of painting house i with color j + 1.

// The houses will look beautiful if they satisfy the following conditions:

// No two adjacent houses are painted the same color.
// Houses equidistant from the ends of the row are not painted the same color. For example, if n = 6, houses at positions (0, 5), (1, 4), and (2, 3) are considered equidistant.
// Return the minimum cost to paint the houses such that they look beautiful.


public class PaintHouse4{

    public static void main(String[] args) {
        
       int cost[][] = { { 100, 200, 400},
                { 100, 200, 400},
                { 100, 200, 400},
                {100,200,400}
        };

        int k = cost[0].length; // no of colors
        int n = cost.length; // no of houses

        int pairs=n/2;

        long prev[][]=new long[k][k];
        
        
        //base case
        //provide color to first pair  -(i and n-1-i)
        for(int c1=0;c1<k;c1++){
            for(int c2=0;c2<k;c2++){
                if(c1==c2){  //same color-mirror
                   prev[c1][c2]=Integer.MAX_VALUE;
                }
                else{
                    prev[c1][c2]=cost[0][c1]+cost[n-1][c2];
                }
            }
        }

        for(int i=1;i<pairs;i++){

            long curr[][]=new long[k][k];
            

            //provide color to each paired houses
            for(int c1=0;c1<k;c1++){
                for(int c2=0;c2<k;c2++){
                    
                    if(c1==c2){
                        curr[c1][c2]=Integer.MAX_VALUE;    //same-color-mirror
                        continue;
                    }

                    long best=Integer.MAX_VALUE;

                    for(int p1=0;p1<k;p1++){
                        for(int p2=0;p2<k;p2++){
                            if(p1==p2){    //same mirror-color 
                                continue;
                            }
                            if(p1!=c1 && p2!=c2){  //not adjacent houses are having same color
                               best=Math.min(best,prev[p1][p2]);
                            }
                        }
                    }

                    curr[c1][c2]=cost[i][c1]+cost[n-1-i][c2]+best;
                }
            }

            prev=curr;



        }
        
        long ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                ans=Math.min(ans,prev[i][j]);
            }
        }

        System.out.println(ans);




    }

}