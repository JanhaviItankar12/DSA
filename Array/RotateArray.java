public class RotateArray {
    public static void rotateLeft(int arr[],int st,int end){
      
      while(st<end){
        int temp=arr[st];
        arr[st]=arr[end];
        arr[end]=temp;
        st++;
        end--;
      }
      
    }

    public static void main(String[] args){

        int arr[]={1,2,3,4,5};
        int n=arr.length;
        int k=1;
        // if 6>5 then 6%5=1
        if(k>n){
          k=k%n;
        }

        else if(k==0 || k==n){
          return;
        }
        // int i=1;
        
        // brute force-approach complexity-O(n2)
        // while(i<=d){
        //    int temp=arr[0];
        //    for(int j=0;j<n-1;j++){
             
        //      arr[j]=arr[j+1];
        //    }
        //    arr[n-1]=temp;
        //    i++;

        // }

        // for(int k=0;k<n;k++){
        //    System.out.println(arr[k]);
        // }



      
         

        // for reversing from 0 to k-1
        rotateLeft(arr,0,k-1);

        // for reversing from k to n-1
        rotateLeft(arr,k,n-1);

        // for reversing from 0 to n-1
        rotateLeft(arr,0,n-1);

         for(int i=0;i<n;i++){
           System.out.println(arr[i]);
        }
    }
}
