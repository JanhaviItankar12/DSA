public class MinimizeTheHeight2 {
    public static void main(String[] args) {
        int arr[]={1,5,8,10};
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int k=2;
        for(int i=0;i<n;i++){
           max=Math.max(max, arr[i]);
           min=Math.min(min, arr[i]);
        }
        
        if((min-k)<0 && (max-k)<0){
            min+=k;
            max+=k;
        }
        else if((min-k)<0){
            min+=k;
            max-=k;
        }
        
        System.out.println(max-min);
        System.out.println(max);

    }
}
