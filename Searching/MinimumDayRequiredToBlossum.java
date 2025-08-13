public class MinimumDayRequiredToBlossum {

    static  boolean possibleAns(int arr[],int mid,int m,int k){
         int bouk=0;
         int flow=0;
         int i=0;
         int ans=0;

         while(i<arr.length){
            if(arr[i]<=mid){
                flow++;
                i++;
                if(flow==k){
                    bouk++;
                    flow=0;
                }

                if(bouk==m){
                    return true;  //earlier return 
                }
            }
            else{
                i++;
                flow=0;
            }
         }

         if(bouk>=m){
            return true;
         }

         

         return false;
         
    }
    public static void main(String[] args) {
        int arr[]={3,4,2,7,13,8,5};
        int bouket=3;
        int flower=2;  //two flowers required to make one bouket
        int n=arr.length;
         
        //when required flower to make bouket is greater than available flower(n)
        if(n<flower*bouket){
            System.out.println("not possible");
        }
        
        int largset=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(largset<=arr[i]){
                largset=arr[i];
            }
        }

        int st=1;
        int end=largset;
        
        int ans=0;

        while(st<=end){
            int mid=st+(end-st)/2;

            if(possibleAns(arr,mid,bouket,flower)){
               ans=mid;
               end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        System.out.println(ans);
        
    }
}
