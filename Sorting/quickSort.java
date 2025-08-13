public class quickSort {

    static int partition(int arr[],int st,int end){
        int idx=st-1;
        
        int pivot=arr[end];

        for(int j=st;j<end;j++){
            if(arr[j]<pivot){
                idx++;
                
                // swap
                int temp=arr[j];
                arr[j]=arr[idx];
                arr[idx]=temp;
            }
        }

        idx++;
        int temp=arr[idx];
        arr[idx]=arr[end];
        arr[end]=temp;
        return idx;
    }

    static void QuickSort(int arr[],int st,int end){
        if(st<end){
            int pivotIndex=partition(arr,st,end);

            // left half
            QuickSort(arr, st, pivotIndex-1);

            // right half
            QuickSort(arr, pivotIndex+1, end);
        }
    }
    public static void main(String[] args) {
        int arr[]={3,8,5,7};

        int n=arr.length;
        int st=0;
        int end=n-1;

        QuickSort(arr,st,end);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
