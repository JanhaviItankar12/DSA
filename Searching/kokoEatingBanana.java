public class kokoEatingBanana {
    static boolean possibleAns(int arr[],int mid,int k){
        int hour=0;
       
        for(int i=0;i<arr.length;i++){
            hour+=Math.ceil((double)arr[i]/mid);
        }

        if(hour<=k){
            return true;
        }
        return false;
         
    }
    public static void main(String[] args) {
        int arr[]={5,10,7};
        int k=4;
        int n=arr.length;

        int st=1;

        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           if(largest<=arr[i]){
             largest=arr[i];
           }
        }
        int end=largest;
        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;

            if(possibleAns(arr,mid,k)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        System.out.println(ans);
    }
}
