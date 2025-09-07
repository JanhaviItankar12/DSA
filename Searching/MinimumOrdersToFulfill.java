public class MinimumOrdersToFulfill {

    static boolean  possibleTime(int arr[],int time,int N){
         int  donut=0;
         for(int i=0;i<arr.length;i++){
            int timeTaken=arr[i];
            int totalTime=0;

            while(totalTime+timeTaken<=time){
               donut++;
               if(donut>=N){
                 return true;
               }
               totalTime+=timeTaken;
               timeTaken+=arr[i];
               
            }

         }
         return false;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int N=10;

        int n=arr.length;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i]>=max){
                max=arr[i];
            }
            if(arr[i]<=min){
                min=arr[i];
            }
        }

        
        int st=min;
        int end=(N*(N+1)/2)*max;
        
        int ans=0;

        while(st<=end){

            int mid=st+(end-st)/2;

            if(possibleTime(arr,mid,N)){
              ans=mid;
              end=mid-1;  //minimum 
            }
            else{
                st=mid+1;
            }
        }

        System.out.println(ans);
    }
}
