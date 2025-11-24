
import java.util.ArrayList;

public class MultiplcationOfArrays {
    public static void main(String[] args) {
        int  arr1[][]={
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };

        int  arr2[][]={
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };

        

        int r1=arr1.length;  //first matrix row
        int c2=arr2[0].length;  //second matrix column

        int arr3[][]=new int[r1][c2];

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        

        for(int i=0;i<r1;i++){
            ArrayList<Integer> list1=new ArrayList<>();
            for(int j=0;j<c2;j++){
                int value=0;
                for(int k=0;k<r1;k++){
                  value+=arr1[i][k]*arr2[k][j];
                }
               arr3[i][j]=value;  //as matrix
               System.out.print(arr3[i][j]);
               list1.add(value);
            }
            list.add(list1);
        }

       System.out.println(list);


    }
}
