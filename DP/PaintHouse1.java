public class PaintHouse1 {
    public static void main(String[] args) {
        int cost[][]={{100,200,400},
        {300,200,400},
        {200,240,500}};

        int n=cost.length;

        

        //base case
        int prevRed=cost[0][0];  //red color
        int prevBlue=cost[0][1];  //blue color
        int prevGreen=cost[0][2];  //green color

        int currRed=0;
        int currBlue=0;
        int currGreen=0;

        for(int i=1;i<n;i++){

            //red color
             currRed=cost[i][0]+Math.min(prevBlue,prevGreen);

            //blue color
            currBlue=cost[i][1]+Math.min(prevRed,prevGreen);

            //red color
            currGreen=cost[i][2]+Math.min(prevRed,prevBlue);

            prevRed=currRed;
            prevBlue=currBlue;
            prevGreen=currGreen;
        }

        System.out.println(Math.min(prevRed,Math.min(prevBlue,prevGreen)));
        
    }
}
