public class TransposeOfMatrix {
    public static void main(String[] args) {
        int arr[][]={
            {1,1,1,1},
            {2,2,2,2},
            {3,3,3,3},
            {4,4,4,4}
        };

        int stR=0;
        int endR=arr.length-1;
        int stC=0;
        int endC=arr[0].length-1;

        while(stR<endR && stC<endC){  //o(n^2)
            int stCol=stC+1;
            int stRow=stR+1;

            while(stCol<=endC && stRow<=endR){
                int temp=arr[stR][stCol];
                arr[stR][stCol]=arr[stRow][stC];
                arr[stRow][stC]=temp;
                stCol++;
                stRow++;
            }

            stR++;
            stC++;
            endR--;
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
