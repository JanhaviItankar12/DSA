public class GCD {
    static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int a=15;
        int b=8;
        int result=gcd(a,b);
        System.err.println(result);
    }
}
