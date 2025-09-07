
import java.util.ArrayList;
import java.util.Collections;



public class FindLeaders {

    static  ArrayList<Integer> OptimizedApproach(int arr[],int n){
        int max=arr[n-1];
        ArrayList<Integer> list=new ArrayList<>();

        list.add(max);

        for(int i=n-2;i>=0;i--){
            if(arr[i]>=max){
                max=arr[i];
                list.add(max);
            }
        }

        Collections.reverse(list);
        return list;
    }

    static ArrayList<Integer> NaiveApproach(int arr[],int n){
      ArrayList<Integer> list=new ArrayList<>();
        
        for(int j=0;j<n-1;j++){
          int count=0;
           for(int i=j+1;i<n;i++){
              if(arr[i]>arr[j]){
                count++;
              }
           }
           if(count==0){
           list.add(arr[j]);
           }
        }

        return list;

}
    public static void main(String[] args) {
        int arr[]={61,61,17};
        int n=arr.length;
        

        ArrayList<Integer> list1=NaiveApproach(arr, n);

        ArrayList<Integer> list2=OptimizedApproach(arr,n);
        System.out.println(list2);

       
    }
}
