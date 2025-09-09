public class MaxSumInConfiguration {

    static int Optimal(int arr[],int n){
        int sum=0;
        int currRot=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            currRot+=arr[i]*i;
        }

        int ans=currRot;

        for(int i=1;i<n;i++){

            //for right 
            //currRot=currRot+n*arr[i-1]-sum
            currRot=currRot+sum-n*arr[n-i];  //for right rotation 
            ans=Math.max(currRot,ans);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={20,20,10,3,16,3,20,14};

        int n=arr.length;

        int count=n;
        int ans=0;

        //o(n2)
        while(count>0){
           int curr=arr[0];
           int sum=0;
           for(int i=1;i<n;i++){
              arr[i-1]=arr[i];
              sum+=arr[i-1]*(i-1);
           }
           arr[n-1]=curr;
           sum+=arr[n-1]*(n-1);
           ans=Math.max(ans,sum);
           count--;
        }
        
        //optimal approach
        int res=Optimal(arr,n);
        System.out.println(res);
    }
}
