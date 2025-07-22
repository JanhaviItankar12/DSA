public class MaxProductSubArray {
    public static void main(String[] args) {
        
    
    int arr[]={1,2,3,4};
    int n=arr.length;
    int ans=arr[0];
    int min=arr[0];
    int max=arr[0];

    for(int i=1;i<n;i++){
        int current=arr[i];

        if(current<0){
           int temp=min;
           max=min;
           max=temp;
        }

        min=Math.min(min,arr[i]*min);
        max=Math.max(max,arr[i]*max);

        ans=Math.max(ans,max);
    }
    System.out.println(ans);
  }
}
