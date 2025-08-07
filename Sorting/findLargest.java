
import java.util.Arrays;

public class findLargest {
    public static void main(String[] args) {
        int arr[]={3,30,34,5,9};
        int n=arr.length;
         
        // step1:convert array into string
        String[] strArr=new String[n];
        for(int i=0;i<n;i++){
           strArr[i]=String.valueOf(arr[i]);
        }

        // compare using sort
        Arrays.sort(strArr,((a,b)->(b+a).compareTo(a+b)));
        
        // if starting idx is zero then ans is zero
        if(strArr[0].equals('0')){
            System.out.println(0);
        }

        StringBuilder s=new StringBuilder();
        for(int i=0;i<strArr.length;i++){
            s.append(strArr[i]);
        }

        System.out.println(s.toString());




    }
}
