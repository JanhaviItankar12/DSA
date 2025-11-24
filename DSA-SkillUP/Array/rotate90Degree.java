public class rotate90Degree{
    public static void main(String[] args) {
        int arr[][]={
            {0,1,2},
            {3,4,5},
            {6,7,8}
        };

        int stR=0;
        int endR=arr.length-1;
        int endCol=arr[0].length-1;

        //reversing
        for(int i=stR;i<=endR;i++){
            int stC=0;
            int endC=endCol;
            while(stC<endC){
               int temp=arr[i][stC];
               arr[i][stC]=arr[i][endC];
               arr[i][endC]=temp;
               stC++;
               endC--;
            }
        }

        


        stR=0;
        endR=arr.length-1;
        int stCol=0;

        while(stR<endR && stCol<endCol){
           
           int stC=stCol+1;
           int stRow=stR+1;

         
           while(stC<=endCol && stRow<=endR){

               //top side and left side
               int temp=arr[stR][stC];
               arr[stR][stC]=arr[stRow][stCol];
               arr[stRow][stCol]=temp;
               
               //bottom and right side
               int temp1=arr[stRow][endCol];
               arr[stRow][endCol]=arr[endR][stC];
               arr[endR][stC]=temp1;

               stC++;
               stRow++;
           }

           stCol++;
           endCol--;
           stR++;
           endR--;

           
        }

         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }
}
