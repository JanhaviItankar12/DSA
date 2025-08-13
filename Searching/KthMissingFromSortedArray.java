public class KthMissingFromSortedArray {

    static int findMissingCount(int arr[],int mid){
        int present=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                present++;
            }
            else{
                break; //array is sorted no need to check further
            }
        }
        int missing=mid-present;
        return missing;
    }
    public static void main(String[] args) {
        int arr[]={2,3,4,7,11};
        int n=arr.length;
        int k=5; //kth missing element

        int st=1;
        int end=arr[n-1]+k;

        while(st<=end){
            int mid=st+(end-st)/2;

            
            int missing=findMissingCount(arr,mid);
            
            if(missing>=k){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
            
        }

        System.out.println(st);

    }
}
