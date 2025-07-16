

public class PrimeNo {
    static boolean solution(int n){
        if(n<=1){
            return false;
        }
        else if(n==2){
            return true;
        }
        // check for even no.
        else if(n%2==0){
            return false;
        }
        // check n is divisible by root n
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    
    }
    public static void main(String[] args) {  //complexity-O(root(n))  bcz we are skipping even no .i.e root(n)/2==root(n)
        int n=11;
        boolean result=solution(n);
        System.out.println(result);
        
    }
}
