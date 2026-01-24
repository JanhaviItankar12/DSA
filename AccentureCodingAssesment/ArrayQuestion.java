public class ArrayQuestion {
    public static void main(String[] args){

        int arr[]={3,4,5,6,2,3,4,5,6,8,5};
        int n=arr.length;

        int large=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }

        int freq[]=new int[large+1];

        for(int i=0;i<n;i++){
            freq[arr[i]]++;
        }

        int count=0;
        for(int i=0;i<freq.length;i++){
           if(freq[i]>=1){
            count++;
           }
        }

        System.out.println(count);




    }
}
