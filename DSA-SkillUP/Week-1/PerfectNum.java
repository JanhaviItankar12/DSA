
import java.util.ArrayList;
import java.util.Arrays;

public class PerfectNum {
    public static void main(String[] args) {
        int n=8128;
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
              list.add(i);
              list.add(n/i);
            }
           
        }

        Integer[] arr=list.toArray(new Integer[0]);
        Arrays.sort(arr);
        int m=arr.length;
        int sum=0;
        for(int i=0;i<m-1;i++){
           sum+=arr[i];
        }
        if(n==sum){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
