public class Rotate180degree {
    public static void main(String[] args) {
        int arr[][]={
            {2,3,4},
            {4,5,9},
            {5,6,8}
        };

        int stR=0;
        int endR=arr.length-1;
        int endcol=arr[0].length-1;
       

        while(stR<endR){
            int stC=0;
            int endC=endcol;
            while(stC<=endC){
                //swap
                int temp=arr[stR][stC];
                arr[stR][stC]=arr[endR][stC];
                arr[endR][stC]=temp;
                stC++;
            }
            stR++;
            endR--;
        }
        
        stR=0;
        endR=arr.length-1;
        for(int i=stR;i<=endR;i++){
            int stC=0;
            int endC=endcol;
            while(stC<endC){
               int temp=arr[i][stC];
               arr[i][stC]=arr[i][endC];
               arr[i][endC]=temp;
               stC++;
               endC--;
            }

        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }

       
    }
}
