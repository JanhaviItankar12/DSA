public class SecondLargeSecondSmall {

    public static int Solution(int arr[]){
        int n=arr.length;
        
        //even
        int large=Integer.MIN_VALUE;
        int secL=Integer.MIN_VALUE;

        for(int i=0;i<n;i+=2){
          if(arr[i]>large){
            secL=large;
            large=arr[i];
          }
          else if(arr[i]>secL){
            secL=arr[i];
          }
        }

        //odd
        int secS=Integer.MAX_VALUE;
        int Small=Integer.MAX_VALUE;

        for(int i=1;i<n;i+=2){
            if(arr[i]<Small){
               secS=Small;
               Small=arr[i];

            }
            else if(arr[i]<secS){
                secS=arr[i];
            }
           
        }
       
       
       
        
        return secL+secS;
    }
    public static void main(String[] args){

        int arr[]={3,7,9,2,6,4,8};

        if(arr.length==0){
            System.out.println("Dont Solve");
        }
        else if(arr.length<=3){
            System.out.println("Dont Solve");
        }
        int res=Solution(arr);
        System.out.println(res);
    }
}
