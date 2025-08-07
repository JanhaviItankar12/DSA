public class InversionCount {

    static int mergeToFindInvCount(int arr[],int st,int mid,int end){
        int i=st;
        int j=mid+1;
        int temp[]=new int[end-st+1];
        int k=0;
        int invCount=0;
        
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                invCount+=(mid-i+1);
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
        
        return invCount;
        
        
    }
    // main function which calls recursively
    static int mergeSort(int arr[],int st,int end){
        int invCount=0;
        
        if(st<end){
            int mid=st+(end-st)/2;
            
            //to count left half side inversion
            invCount+=mergeSort(arr,st,mid);
            
            // to count right half side inversion
            invCount+=mergeSort(arr,mid+1,end);
            
            // to count merging inversion
            invCount+=mergeToFindInvCount(arr,st,mid,end);
            
            
            
        }
        return invCount;
    }
    public static void main(String args[]){
        int arr[]={24 ,18 ,38 ,43 ,14 ,40 ,1 ,54};

        int n=arr.length;

        // brute-force approach
        // int count=0;

        // for(int i=0;i<n;i++){    //o(n^2)
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]>arr[j] && i<j){
        //            count++;
        //         }
        //     }
        // }

        // System.out.println(count);


        // optimal approach
       
        int st=0;
        int end=n-1;
        
        // step1:call first main mergeSort function
        int res=mergeSort(arr,st,end);
        System.out.println(res);
    }
}
