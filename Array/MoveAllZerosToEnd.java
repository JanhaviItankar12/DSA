

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int arr[]={0,1,3,5,9,0,3,0,7,0,2};
        int n=arr.length;
        int j=0;

        // append non-zero elements
        for(int i=0;i<arr.length;i++){
           if(arr[i]!=0){
              arr[j]=arr[i];
              j++;
           }
        }
        
        // append zeros at end
        for(int i=j;i<arr.length;i++){
            arr[i]=0;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
