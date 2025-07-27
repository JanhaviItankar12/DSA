public class SumOfAllSubArray {
    public static void main(String[] args){
        int arr[]={1,2,3};
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int subArraySum=0;
            for(int j=i;j<n;j++){
                subArraySum+=arr[j];
                sum+=subArraySum;
            }
            
        }
        System.out.println(sum);
    }
}
