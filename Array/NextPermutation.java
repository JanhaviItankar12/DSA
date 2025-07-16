public class NextPermutation {
    static void reverse(int arr[],int st,int end){
           while(st<end){
                int temp=arr[st];
                arr[st]=arr[end];
                arr[end]=temp;
                st++;
                end--;
        }
    }
    
    static void swap(int arr[],int j,int k){
         int temp=arr[j] ;
         arr[j]=arr[k];
         arr[k]=temp;
        
    }



    static void Permutation(int arr[],int n){
        
        int pivot=-1;

        //step1:find pivot
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
               
                pivot=i;
                break;
            }
        }

        // if pivot not found
        if(pivot==-1){
           reverse(arr,0,n-1);

        }
        // step2:find larger after pivot
       for(int i=n-1;i>pivot;i--){
         if(arr[i]>arr[pivot]){
            swap(arr,pivot,i);
            break;
         }
       }
        
        // step3:reverse array from j+1 to n-1
         reverse(arr,pivot+1,n-1);
    }
    public static void main(String[] args){
        int arr[]={3,2,1,8,9};
        int n=arr.length;
        
        Permutation(arr,n);
         for (int i = 0; i < n; i++) {
             System.out.print(arr[i]);
         }



       
        
        

        


    }
}
