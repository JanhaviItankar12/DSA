

public class ReverseArray {
    public static void main(String[] args) {
      int arr[]={1,7,8,4,5,6,7};
      int n=arr.length;
        int st=0;
        int end=arr.length-1;
        
        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }  

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
