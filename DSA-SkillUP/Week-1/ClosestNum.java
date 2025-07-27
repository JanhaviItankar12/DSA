public class ClosestNum {
    public static void main(String[] args) {
       int n=-15;
       int m=6;
      
       int floor=Math.floorDiv(n, m);
       int ceil=Math.ceilDiv(n, m);
       
       int floorValue=floor*m;
       int ceilValue=ceil*m;

       int diff_floor=Math.abs(n-floorValue);
       
       int diff_ceil=Math.abs(n-ceilValue);

       
       

       if(diff_floor<diff_ceil){
        System.out.println(floorValue);
       }
       else if(diff_floor>diff_ceil){
        System.out.println(ceilValue);
       }
       else{
         if(Math.abs(floorValue)>Math.abs(ceilValue)){
            System.out.println(floorValue);
         }
         else{
            System.out.println(ceilValue);
         }
       }
       
    
       
    }
}
