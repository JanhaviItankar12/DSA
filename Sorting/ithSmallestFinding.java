public class ithSmallestFinding{

    public static int randomSelection(int arr[],int k,int st,int end){
     
        if(st==end){
           return arr[st];  //kth element
        }

        int pivot=partition(arr,st,end);
        

        if(pivot==k-1){
            return arr[pivot];
        }
        else if (pivot>k-1) {
            return randomSelection(arr,k,st,pivot-1);
        }
        else{
            return randomSelection(arr, k-pivot, pivot+1, end);
        }

    }

    public static int partition(int arr[],int st,int end){
        int pivot=arr[end];
        int i=st-1;

        for(int j=st;j<end;j++){
            if(arr[j]<=pivot){
                i++;

                //swap
                swap(arr,i,j);
            }
        }

        i++;
        swap(arr,i,end);
        return i;



    }

    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        int arr[]={4,6,3,4,5,2,4,5};
        int k=6;
        
        int st=0;
        int end=arr.length-1;
        int ans=randomSelection(arr,k,st,end);
        System.out.println("kth smallest element: "+ans);
    }
}
