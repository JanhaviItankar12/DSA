

public class SecondLargest {
    public static int solution(int arr[],int n){
        int max1,max2;
        

        if(arr[0]>arr[1]){
            max1=arr[0];
            max2=arr[1];
        }
        else{
            max1=arr[1];
            max2=arr[0];
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]>max1){
                max2=max1;
                max1=arr[i];
            }
            else if(arr[i]>max2 && arr[i]!=max1){
               max2=arr[i];
            }
        }

        if(max1==max2){
            return -1;
        }
        else{
            return max2;
        }
    }
    public static void main(String[] args){
       
        int arr[]={189,89,67,190,3};
        int n=arr.length;

         // brute force-approach
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             // swap
        //             int temp=arr[i];

        //             arr[i]=arr[j];
        //             arr[j]=temp;
                    
                                          
        //         }
        //     }
        // }

        // //print array
        // System.out.println(arr[n-2]);

        // optimized approach
        int result=solution(arr,n);
        System.out.println(result);
        

    }
}
