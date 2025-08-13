public class LastMomentAntFalls {
    public static void main(String args[]){
        int n=4;  //length of stick
        int left[]={1,2};
        int right[]={};
        
        // step1:find left side ant required max time to fall of
        int maxLeft=-1;
        // check if no ant present in any postion     
        if(left.length==0){
            maxLeft=0;
        }
        else{
          maxLeft=left[0];
          for(int i=1;i<left.length;i++){
            if(maxLeft<left[i]){
                maxLeft=left[i];
            }
          }
        }   
       
        // step1:find left side ant required max time to fall of
       int maxRight=-1;

       //check if no ant present in any postion     
       if(right.length==0){
         maxRight=0;
       }
       else{
        maxRight=n-right[0];
         for(int i=1;i<right.length;i++){
           if(maxRight<(n-right[i])){
            maxRight=(n-right[i]);
           }
         }
       }   

      int maxTime=Math.max(maxLeft,maxRight);
      System.out.println(maxTime);

    }
}
