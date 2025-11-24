
import java.util.ArrayList;
import java.util.Collections;

public class ArrangeTiles {
    public static void main(String[] args) {
        int arr[]={1,1,5,3,2};
        int n=arr.length;

        int mat[][]=new int[3][4];
        
        int endR=mat.length;
        int endC=mat[0].length;
        
        int type=0;
        int remaining=arr[type];

        ArrayList<ArrayList<Integer>> list1=new ArrayList<>();

        for(int r=0;r<endR;r++){
            ArrayList<Integer> list=new ArrayList<>();
            //move left-right
            if(r%2==0){
             
              for(int c=0;c<endC;c++){
                mat[r][c]=type+1;
                list.add(mat[r][c]);
                remaining--;
                if(remaining==0 && type<n-1){
                    type++;
                    remaining=arr[type];
                }
              }
              
              
            }
            //right to left
            else{
            
              for(int c=endC-1;c>=0;c--){
                mat[r][c]=type+1;
                list.add(mat[r][c]);
                remaining--;
                if(remaining==0 && type<n-1){
                    type++;
                    remaining=arr[type];
                }
              }
               Collections.reverse(list);
              
            }
            list1.add(list);
        }


        for(int i=0;i<endR;i++){
            for(int j=0;j<endC;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

        System.out.println(list1);



    }
}
