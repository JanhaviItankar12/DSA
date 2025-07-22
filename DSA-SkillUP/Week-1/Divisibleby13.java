import java.math.BigInteger;

public class Divisibleby13 {
    public static void main(String[] args) {
        String s="11111111111111188888888888888888999999999997";

        BigInteger num=new BigInteger(s);
        
        if(num.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO)){
            System.out.println(true);
        }
        else{
            System.err.println(false);
        }
    }
}
