public class hcf{

    public static int LCM(int a,int b){
        return (a*b)/HCF(a,b);
    }

    public static int HCF(int a,int b){
       if(b==0) return a;

       return HCF(b,a%b);
    }
    public static void main(String[] args){

        int a=80;
        int b=56;

        int res=HCF(a,b);
        int lcm=LCM(a, b);
        System.out.println(lcm);
    }
}
