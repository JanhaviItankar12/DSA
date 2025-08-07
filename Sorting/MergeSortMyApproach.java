public class MergeSortMyApproach {

      
    static void merge(int arr[],int st,int mid,int end){
        int i=st;
        int j=mid+1;
       
        
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                
                i++;
               
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                
                
                int idx=j;
                
                while(idx+1<=end && arr[idx]>arr[idx+1]){
                    // swap
                    int t=arr[idx];
                    arr[idx]=arr[idx+1];
                    arr[idx+1]=t;
                    idx++;
                }
            }
        }
        
        
        
        
        
        
        
        
    }

    static void mergeSort(int arr[],int st,int end){
         if(st<end){
            
            int mid=st+(end-st)/2;
            
            // left half
            mergeSort(arr,st,mid);
            
            // right half
            mergeSort(arr,mid+1,end);
            
            // merge both half
            merge(arr,st,mid,end);
        } 
    }
    public static void main(String[] args) {
        int arr[]={5,1,3,2,4,8,9,23,14};
        int n=arr.length;
        int st=0;
        int end=n-1;
        mergeSort(arr,st,end);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
}
