public class EvenDigits {
   public static void main(String[] args) {

     int arr[]={4,7,8,9,4,5,6,7,8,9,8};
     int n=arr.length;
     
     if(n%2==0){
        System.out.println(n/2);
     }
     else{
        System.out.println((n/2)+1);
     }
   }
}
