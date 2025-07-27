public class BinaryConversion {
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder();
        int n=8;

        while(n>0){
          int binary=n%2;
          s.append(binary);
          n/=2;
        }

        

        String res=s.reverse().toString();
        System.out.println(res);
    }
}
