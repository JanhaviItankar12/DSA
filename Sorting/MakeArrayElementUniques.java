
import java.util.Arrays;

public class MakeArrayElementUniques{
    public static void main(String[] args) {
        int arr[]={3, 2 ,1 ,2 ,1 ,7};
        int n=arr.length;

        // step1:sort array
        Arrays.sort(arr);

        // step2:calculate operation 
        int op=0;
        int i=1;
        while(i<n){
            if(arr[i-1]==arr[i]){
                arr[i]++;
                op++;
                i++;
            }
            else if(arr[i-1]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[i-1]+1;
                op+=arr[i]-temp;
            }
           else{
              i++;
           }
        }

        System.out.println(op);

    }
}