public class CheckArraySorted {

   
    static boolean CheckArraySorted(int arr[],int n){
        
       if(n==0 || n==1){
         return true;
       }

       return arr[n-1]>arr[n-2] && CheckArraySorted(arr, n-1);

    }
    public static void main(String[] args) {
        int arr[]={2,4,5};
        int n=arr.length;

        boolean isSorted=CheckArraySorted(arr,n);
        System.out.println(isSorted);
    }
}
