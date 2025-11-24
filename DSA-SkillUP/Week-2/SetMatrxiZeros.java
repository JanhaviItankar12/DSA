public class SetMatrxiZeros {
    static void bruteForce(int arr[][],int endR,int endC){
        boolean zeroMatrix[][]=new boolean[endR+1][endC+1];
         for(int i=0;i<=endR;i++){
            for(int j=0;j<=endC;j++){
                
                if(arr[i][j]==0){
                  zeroMatrix[i][j]=true;
                }
                
            }
         }



         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
               if(zeroMatrix[i][j]){
                  int stR=0;
                  int stC=0;
                  while(stR<=endR && stC<=endC){
                    arr[stR][j]=0;
                    arr[i][stC]=0;
                    stR++;
                    stC++;
                  }
               }
            }
          
        }
    }

    static void better(int arr[][],int endR,int endC){
          int rows[]=new int[endR+1];
          int cols[]=new int[endC+1];

          for(int i=0;i<=endR;i++){
            for(int j=0;j<=endC;j++){
                if(arr[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
          }

          for(int i=0;i<=endR;i++){
            for(int j=0;j<=endC;j++){
                if(rows[i]==1 || cols[j]==1){
                    arr[i][j]=0;
                }
            }
          }


    }

    static void optimizedApproach(int arr[][],int endR,int endC){
        boolean zerothRow=false,zerothCols=false;

        //check if first row contains zero
        for(int j=0;j<=endC;j++){
                if(arr[0][j]==0){
                   zerothRow=true;
                }
        }

         //check if first col contains zero
        for(int j=0;j<=endR;j++){
                if(arr[j][0]==0){
                   zerothRow=true;
                }
        }

        for(int i=1;i<=endR;i++){
            for(int j=1;j<=endC;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }


        for(int i=1;i<=endR;i++){
            for(int j=1;j<=endC;j++){
                if(arr[i][0]==0 || arr[0][j]==0 ){
                    arr[i][j]=0;
                }
            }
        }

        //make first row element zero if it is true
        if(zerothRow){
            for(int i=0;i<=endC;i++){
                arr[0][i]=0;
            }
        }

        if(zerothCols){
            for(int i=0;i<=endC;i++){
                arr[i][0]=0;
            }
        }

        

    }
    public static void main(String args[]){
         int arr[][]={
            {2,5,6},
            {3,0,5},
            {2,5,8}
         };
         
         int endR=arr.length-1;
         int endC=arr[0].length-1;

        //  bruteForce(arr,endR,endC);  //time:o(n*m) ,space:o(n*m)
        //  better(arr,endR,endC);    //time:o(n*m) ,space:o(n+m)
            optimizedApproach(arr,endR,endC); //time:o(n*m) ,space:o(1)
         
         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }



    }
}
