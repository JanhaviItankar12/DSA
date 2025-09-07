public class QuickSortRecursion {

    static int  partition(int arr[],int st,int pivotIdx){
        int idx=st-1;

        for(int i=st;i<pivotIdx;i++){
            if(arr[i]<arr[pivotIdx]){
                idx++;

                //swap;
                int temp=arr[idx];
                arr[idx]=arr[i];
                arr[i]=temp;
            }
        }

        //swap last element
        idx++;
        int temp=arr[idx];
        arr[idx]=arr[pivotIdx];
        arr[pivotIdx]=temp;
        return idx;


    }

    static void QuickSort(int arr[],int st,int end){
       if(st<end){

        int pivotIndex=partition(arr,st,end);

        // call left side of pivotIndex
        QuickSort(arr, st, pivotIndex-1);
        
        // call right side of pivotIndex
        QuickSort(arr, pivotIndex+1, end);
       }
    }
    public static void main(String[] args) {
        int arr[]={5,7,3,2,5,6,6};
        int n=arr.length;
        
        int st=0;
        int end=n-1;
        QuickSort(arr,st,end);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
