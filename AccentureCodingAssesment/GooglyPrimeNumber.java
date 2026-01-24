public class GooglyPrimeNumber {
    public static void main(String[] args){
        int n=44;
        int sum=0;

        while(n>0){
          sum+=n%10;
          n/=10;
        }
        
        boolean isPrime=false;
        double root=Math.sqrt(sum);

        for(int i=2;i<=root;i++){

            if(sum%i!=0){
               isPrime=true;
            }
        }

        System.out.println(isPrime);
        
    }
}
