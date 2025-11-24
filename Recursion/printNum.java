public class printNum {

    static void printNumbers(int num){

        if(num==1){
            System.out.println(num);
            return;
        }
        System.out.println(num);
        printNumbers(num-1);
    }

    static int factorial(int num){

        if(num==1){
            return 1;
        }
        int fact=num*factorial(num-1);
        return fact;
    }

    
    //this for finding for fibonacci
    static int fibonacci(int n){
        if(n==0){
           return 0;
        }
        else if(n==1){
            return 1;
        }
        
        return fibonacci(n-1)+fibonacci(n-2);
        
        
    }
    public static void main(String[] args) {
        int num=6;

        printNumbers(num);
        int fact=factorial(num);
        System.out.println(fact);

        //this is for printing fibonacci series
        for(int i=0;i<=6;i++){
            System.out.println(fibonacci(i));
        }
    }
}
