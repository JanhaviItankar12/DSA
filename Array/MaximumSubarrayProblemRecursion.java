public class MaximumSubarrayProblemRecursion {

    static int findCrossSum(int a[],int st,int mid,int end){

        //left half
        int leftSum=Integer.MIN_VALUE;
        int sum=0;

        for(int i=mid;i>=st;i--){
           sum=sum+a[i];
           if(sum>leftSum){
            leftSum=sum;
           }
        }


        //right half
        int rightSum=Integer.MIN_VALUE;
        sum=0;

        for(int i=mid+1;i<=end;i++){
            sum=sum+a[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }

        return leftSum+rightSum;
    }

    static int findMaxSumSubarry(int a[],int st,int end){

       if(st<=end){
        if(st==end){
            return a[st];
        }
       
        int mid=st+(end-st)/2;

        int maxSumLeft=findMaxSumSubarry(a, st, mid);
        int maxSumRight=findMaxSumSubarry(a, mid+1, end);

        int crossSum=findCrossSum(a,st,mid,end);

        int max= Math.max(maxSumLeft,maxSumRight);
        
        return Math.max(max,crossSum);
       }
       return 0;

       
    }
    public static void main(String args[]){
        int a[]={2,-6,9,9,-4,-5,-6,9,7,5}  ;
        int n=a.length;
        
        int low=0;
        int high=n-1;
        int res=findMaxSumSubarry(a,low,high);
        System.out.println(res);
    }
}
