
import java.util.ArrayList;



public class ArrayDuplicates {
    public static void main(String[] args) {
        int arr[]={2,4,5,3,4,5}; 
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();

        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(largest<=arr[i]){
                largest=arr[i];
            }
        }

        int count[]=new int[largest+1];

        for(int i=0;i<n;i++){
            int digit=arr[i];
            count[digit]++;
        }

        for(int i=0;i<count.length;i++){
            if(count[i]>1){
                list.add(i);
            }
        }

        System.out.println(list);
    }
    
    
}
