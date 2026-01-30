
import java.util.Random;

public class kthSmallest {

    static Random random=new Random();

    public static int SelectionProblem(int arr[],int st,int k,int end){

        if(st==end){
            return arr[st];
        }
       
       int pivotIdx=randomPivot(arr,st ,end);

       if(pivotIdx==k-1){
          return arr[pivotIdx];
         
       }
       else if(pivotIdx<k-1){
         return SelectionProblem(arr, pivotIdx+1, k, end);
       }
       else{
        return SelectionProblem(arr, st, k, pivotIdx-1);
       }
        
    }

    public static int randomPivot(int arr[],int st,int end){
       
        int randoIndex=st+random.nextInt(end-st+1);
        swap(arr,randoIndex,end);
        return partition(arr,st,end);
    }

    public static void swap(int arr[],int i,int j) {
        
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int partition(int arr[],int st,int end){
        int pivot=arr[end];
        int low=st-1;

        for(int i=st;i<end;i++){

            if(arr[i]<=pivot){
                low++;

                swap(arr,i,low);
            }
        }

        swap(arr,low+1,end);
        return low+1;
    }


    public static void main(String[] args){

        int arr[]={2,4,5,3,4,9,6,5,7};
        int n=arr.length;
        int k=5;
        
        
        int ans=SelectionProblem(arr,0,k,n-1);
        System.out.println(ans);


    }
}
