

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={0,1,2,0,1,2};
        int n=arr.length;
        
        // O(n^2)qq
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                  int temp=arr[i];
                  arr[i]=arr[j];
                  arr[j]=temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }

    }
}
