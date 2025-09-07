import java.util.Random;

public class RandomizedQuickSort {

    static  Random rand=new Random();

    static void swap(int arr[],int idx,int end){
        int temp=arr[idx];
        arr[idx]=arr[end];
        arr[end]=temp;
    }


    static int partition(int arr[],int st,int end){
        int idx=st-1;
        int pivot=arr[end];

        for(int i=st;i<end;i++){
            if(arr[i]<pivot){
               idx++;

               //swap;
               swap(arr,i,idx);

            }
        }

        idx++;
        swap(arr,idx,end);
        return idx;
    }

    static int randomizedSort(int arr[],int st,int end){
        int randomIndex=st+rand.nextInt(end-st+1);
        swap(arr,randomIndex,end);
        return partition(arr, st, end);
    }

    static void quickSort(int arr[],int st,int end){

        if(st<end){
            int pivotIndex=randomizedSort(arr,st,end);

            quickSort(arr, st, pivotIndex-1);
            quickSort(arr, pivotIndex+1, end);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,4,23,5,6,7,8};
        int n=arr.length;
        
        int st=0;
        int end=n-1;
        quickSort(arr,st,end);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
