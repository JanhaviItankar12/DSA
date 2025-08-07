public class SelectionSort {
    public static void main(String args[]){
         int arr[]={2,-8,5,9};
         int n=arr.length;
        
         for(int i=0;i<n-1;i++){
            int SI=i;
            
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[SI]){
                    SI=j;
                }
            }
            
            // swap
            int temp=arr[SI];
            arr[SI]=arr[i];
            arr[i]=temp;
        }

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
