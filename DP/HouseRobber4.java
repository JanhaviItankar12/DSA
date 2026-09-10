public class HouseRobber4 {

      public static boolean canRob(int house[],int k,int capability){
          
        int n=house.length;
        int maxStole=0;

          for(int i=0;i<n;){
              
               if(house[i]<=capability){
                  
                  maxStole++;

                  if(maxStole>=k){
                     return true;
                  }
                  i+=2;

               }
               else{
                  i++;
               }
          }

          return false;

          
      }
      public static void main(String args[]){
            
        int house[]={2,3,4,5};
        int k=2;

        //check capabity to stole atleast k houses in this amount
        int low=0;
        int high=0;

        for(int amt:house){
            high=Math.max(amt,high);
        }

        while(low<high){

            int mid=low+(high-low)/2;

            if(canRob(house,k,mid)){
                high=mid;   //if mid is answer then possible answer could be lesser also
            }
            else{
                low=mid+1;
            }
        }

        System.out.println(low);


      }
   
}