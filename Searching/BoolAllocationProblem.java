public class BoolAllocationProblem {
    static boolean possibleAns(int arr[],int mid,int k){
        int stu=1;
        int totalPages=0;

        for(int i=0;i<arr.length;i++){
           if(totalPages+arr[i]>mid){
             stu++;
             totalPages=arr[i];
           }
           else{
            totalPages+=arr[i];
           }
        }

        if(stu<=k){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int arr[]={12, 34, 67, 90};
        int k=2;  //no. of students
        int n=arr.length;
        
        if(k>n){
            System.out.println(-1);
        }
        int totalpage=0;
        for(int i=0;i<n;i++){
            totalpage+=arr[i];
        }

        int st=0;
        int end=totalpage;
        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;

            if(possibleAns(arr,mid,k)){
                ans=mid;
                end=mid-1;  //to find minimum value
            }
            else{
              st=mid+1;
            }
        }

        System.out.println(ans);

        

    }
}
