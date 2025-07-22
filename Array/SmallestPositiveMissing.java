

public class SmallestPositiveMissing {
    public static void main(String[] args){
        int arr[]={-8, 0, -1, -4, -3};
        int n=arr.length;


        // // brute-force appraoch
        // // we have to find positive missing number
        // int smallest=1;

        // // step1:sort array
        // Arrays.sort(arr);
         
        // // step2:apply linear search to check small missing number
        // for(int i=0;i<n;i++){
        //     if(arr[i]==smallest){
        //         smallest++;
        //     }
        // }

        // System.out.println(smallest);

         
        // optimal appraoch
        
        for(int i=0;i<n-1;i++){
            while(arr[i]>0 && arr[i]<=n && arr[i]-1 !=i){
           
                int temp=arr[i];
                arr[i]=arr[temp-1];
                arr[temp-1]=temp;
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
               int ans=i+1; 
               System.out.println("running..."+ans);
               break;

            }
        }
        
    }
}
