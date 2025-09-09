
import java.util.*;

public class ConstructArrayFromPairSum {
    public static void main(String args[]){
        int arr[]={6};   //pair sum array
        int n=arr.length;
        int N = (int)((1 + Math.sqrt(1 + 8 * n)) / 2);
        
        ArrayList<Integer> list=new ArrayList<>();

        int s1=arr[0],s2=arr[1],s3=arr[N-1];

        int a1=(s1+s2-s3)/2;

        list.add(a1);
        for(int i=1;i<N;i++){
            list.add(arr[i-1]-a1);
        }

        System.out.println(list);

    }
}
