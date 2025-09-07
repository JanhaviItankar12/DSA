
import java.util.ArrayList;

public class IndexForSubArraySumTarget {
    public static void main(String[] args) {
        int arr[]={19, 23, 15 ,6, 6 ,2 ,28 ,2};
        int k=2;
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();

        int currSum=0;
        int j=0;
        int i=0;
        while(i<n){ 
            currSum+=arr[i];
            while(currSum>k && j<=i){  //sliding window
                currSum-=arr[i];
                j++;
            }
            if(currSum==k){
                list.add(j+1);  //i based index
                list.add(i+1);
                break;
            }
            i++;
        }

        System.out.println(list);
    }
}
