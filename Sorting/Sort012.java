

public class Sort012 {
    public static void main(String[] args) {
        int arr[]={0,1,0,1,2,0,0,1,0,2,2};
        int n=arr.length;
    //     int count1=0;
    //     int count0=0;
    //     int count2=0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]==0){
    //             count0++;
    //         }
    //         else if(arr[i]==1){
    //             count1++;
    //         }
    //         else if(arr[i]==2){
    //             count2++;
    //         }
    //     }

        
    //   int idx=0;
    //   for(int i=0;i<count0;i++){
    //     arr[idx]=0;
    //     idx++;
    //   }
    //   for(int i=0;i<count1;i++){
    //     arr[idx]=1;
    //     idx++;
    //   }
    //   for(int i=0;i<count2;i++){
    //     arr[idx]=2;
    //     idx++;
    //   }


    //     for(int i=0;i<n;i++){
    //         System.out.print(arr[i]);
    //     }

    // optimal approach-DNF Algo
    int low=0;
    int mid=0;
    int high=n-1;
    
    // Step1:array is now unsorted so consider index from mid to high

    while(mid<=high){
         if(arr[mid]==0){
            // swap
            int temp= arr[mid];
            arr[mid]=arr[low];
            arr[low]=temp;
            low++;
            mid++;
         }
         else if(arr[mid]==1){
            mid++;
         }
         else if(arr[mid]==2){
            int temp=arr[mid];
            arr[mid]=arr[high];
            arr[high]=temp;
            high--;


         }
        }
        
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }

        

    }
}
