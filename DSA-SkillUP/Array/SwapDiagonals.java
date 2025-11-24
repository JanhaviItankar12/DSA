public class SwapDiagonals {
    public static void main(String[] args) {
        int arr[][]={
            {4,5,6},
            {3,8,9},
            {1,2,6}
        };

        int stR=0;
        int endR=arr.length-1;
        int stC=0;
        int endC=arr[0].length-1;

        while(stR<endR && stC<endC){
            
            //swap top side element
            int temp1=arr[stR][stC];
            arr[stR][stC]=arr[stR][endC];
            arr[stR][endC]=temp1;

            //swap bottom side element
            int temp2=arr[endR][stC];
            arr[endR][stC]=arr[endR][endC];
            arr[endR][endC]=temp2;

            stR++;
            endR--;
            stC++;
            endC--;
        }

          for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
