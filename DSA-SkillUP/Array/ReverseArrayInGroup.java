

public class ReverseArrayInGroup {

    static void bruteForce(int arr[],int k){
        int n=arr.length;
        int group=n/3;
        int i=0;
        int c=0;

        while(i<n){
            if(c<group){
            int st=i;
            int end=k+i-1;
            while(st<end){
                int temp=arr[st];
                 arr[st]=arr[end];
                 arr[end]=temp;
                 st++;
                 end--;
            }
            c++;
            
           }
           i=i+k;
            
        }

        int remain=n-(k*group);
        int st=n-remain;
        int end=n-1;
        while(st<end){
             int temp=arr[st];
             arr[st]=arr[end];
             arr[end]=temp;
             st++;
             end--;
        }


        for(int m=0;m<n;m++){
          System.out.println(arr[m]);
        }
    }
    
    static void  optimized(int arr[],int k){
        int n=arr.length;
        for(int i=0;i<n;i+=k){
            int st=i;
            int end=Math.min(i+k-1,n-1);
            while(st<end){
                 int temp=arr[st];
                 arr[st]=arr[end];
                 arr[end]=temp;
                 st++;
                 end--;
            }


        }

        for(int m=0;m<n;m++){
          System.out.println(arr[m]);
        }


    }
    
    public static void main(String args[]){
        int arr[]={5,2,4,6,7};
        int k=3;

        // bruteForce(arr, k);
        optimized(arr,k);

       
    }
}
