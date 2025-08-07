public class BubbleSortDec {
    public static  void main(String args[]){
        int arr[]={5,3,1,2,4};

        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){  //to shift all lower values to right direction
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
