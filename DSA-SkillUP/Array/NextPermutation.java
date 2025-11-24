public class NextPermutation {
    public static void main(String[] args) {
        int arr[]={2,4,1,7,5,0};
        int n=arr.length;
        
        //step1:to find where decending order break
        int idx=-1;
        for(int i=n-1;i>=1;i--){
             if(arr[i-1]<arr[i]){
               idx=i-1;
               break;
             }
        }
        
        //if idx is greater if not i.e the order is last lexicographic available so just only reverse it i.e in acending order
        if(idx>-1){
        //step2:find next greater than this index element and swap;
        for(int i=n-1;i>idx;i--){
            if(arr[i]>arr[idx]){
                //swap
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                break;
            }
        }
      }

        //reverse this decending order into ascending order
        int st=idx+1;
        int end=n-1;
        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }

        
    }
}
