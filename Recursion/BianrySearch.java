
import java.util.Arrays;

public class BianrySearch {
    static boolean  binarySearch(int arr[],int k,int st,int end){
        if(st>end){
            return false;
        }

        int mid=st+(end-st)/2;
        if(k==arr[mid]){
            return true;
        }
        else if(k>arr[mid]){
            return binarySearch(arr, k, mid+1, end);
        }
        else{
            return binarySearch(arr, k, st, mid-1);
        }

    }
    public static void main(String[] args) {
        int arr[]={2,5,6,8,9,4,45};
        int n=arr.length;
        int k=54;
        int st=0;
        int end=n-1;

        Arrays.sort(arr);

        boolean isFound=binarySearch(arr,k,st,end);
        System.out.println(isFound);

       


    }
}
