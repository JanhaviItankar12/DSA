public class Factorial {
    static int factorial(int n){
        if(n==0){
           return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        int n=5;

        // by loop
        // int i=1;
        // int prod=1;
        // while(i<=n){
        //    prod*=i;
        //    i++;
        // }

        // System.out.println(prod);

        // by recursion
        
        int res=factorial(n);
        System.out.println(res);
        
    }
}
