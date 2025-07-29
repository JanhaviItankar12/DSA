
import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int arr[]={8 ,12 ,10, 12 ,9, 12};
        int n=arr.length;
        
        Arrays.sort(arr);
                 
        for(int i=0;i<n;i++){
            int h=n-i;
            if(arr[i]>=h){
              System.out.println(h);
              break;
            }
        }
       

    }
}
