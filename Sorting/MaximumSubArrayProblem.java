public class MaximumSubArrayProblem {
     static int merge(int arr[],int st,int mid,int end){
        
        // calculate left sum
        int left_sum=Integer.MIN_VALUE;
        int sum1=0;
        int i=mid;
        
        while(i>=0){
            if(sum1>left_sum){
                sum1=sum1+arr[i];
                left_sum=sum1;
            }
            i--;
        }
        
        // calculate right sum
        int right_sum=Integer.MIN_VALUE;
        int sum2=0;
        int j=mid+1;
        
        while(j<=end){
            if(sum2>right_sum){
                sum2=sum2+arr[j];
                right_sum=sum2;
            }
            j++;
        }
        
        return left_sum+right_sum;
    }
    static int mergeSort(int arr[],int st,int end){
        
        if(st==end) return arr[st];
            
        int mid=st+(end-st)/2;
            
        //   left half
        int leftSum=mergeSort(arr,st,mid);
        
        // right half
        int rightSum=mergeSort(arr,mid+1,end);
        
        // merge to calculate cross sum
        int crossSum=merge(arr,st,mid,end);
        
        return Math.max(Math.max(leftSum,rightSum),crossSum);
    }
    public static void main(String[] args) {
        int arr[]={2,3,-8,7};
        int n=arr.length;
        int st=0;
        int end=n-1;
        int res=mergeSort(arr,st,end);
        System.out.println(res);
    }
}
