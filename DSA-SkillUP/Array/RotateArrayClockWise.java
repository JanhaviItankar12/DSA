public class RotateArrayClockWise {
    public static void main(String[] args) {
        int arr[]={9,1,7,9,6,5,5};
        int k=17;
        int n=arr.length;
        
        // step1:reverse
        int st=0;
        int end=n-1;
        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }

        int st1=0;
         if(k>n){
            int g=k/n;
            k=k-(g*n);
        }
        int end1=k-1;
       
        while(st1<end1){
            int temp=arr[st1];
            arr[st1]=arr[end1];
            arr[end1]=temp;
            st1++;
            end1--;
        }

        int st2=k;
        int end2=n-1;
        while(st2<end2){
            int temp=arr[st2];
            arr[st2]=arr[end2];
            arr[end2]=temp;
            st2++;
            end2--;
        }

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }


    }
}
