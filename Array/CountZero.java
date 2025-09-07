public class CountZero {
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0};

        int n=arr.length;
        int st=0;
        int end=n-1;
        int firstZeroIndex=-1;
        
        while(st<=end){
            
            int mid=st+(end-st)/2;
            
            if(arr[mid]==0){
                firstZeroIndex=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        if(firstZeroIndex==-1){
            System.out.println(0);
        }
        else{
            System.out.println(n-firstZeroIndex);
        }
        
        
    }
}
