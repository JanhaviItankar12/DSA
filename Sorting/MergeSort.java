public class MergeSort {
    static void merge(int arr[],int st,int mid,int end){
        int j=mid+1;
        int i=st;
        int temp[]=new int[end-st+1];
        int k=0;

         while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
               temp[k]=arr[i];
               i++;
               k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
         }

         while(i<=mid){
             temp[k]=arr[i];
               i++;
               k++;
         }

         while(j<=end){
             temp[k]=arr[j];
               j++;
               k++;
         }

         for(int p=st;p<=end;p++){
             arr[p]=temp[p-st];
         }
    }
    static void mergeSort(int arr[],int st,int end){
        if(st<end){
            int mid=st+(end-st)/2;

            // left half
            mergeSort(arr,st,mid);
            
            

            // right half
            mergeSort(arr,mid+1,end);

            merge(arr,st,mid,end);


        }
    }
    public static void main(String[] args) {
        int arr[]={5,4,7,1,3,9};
        int n=arr.length;
        int st=0;
        int end=n-1;
        mergeSort(arr,st,end);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
}
