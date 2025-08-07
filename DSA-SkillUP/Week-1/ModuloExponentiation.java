public class ModuloExponentiation {
    static int PowMode(int x,int n,int M){
        if(x==0){
            return 0;
        }
        else if(x==1){
            return 1;
        }
        else if(n==0){
            return 1;
        }
        else if(n==1){
            return x;
        }

        int binaryForm=n;
        long base=x%M;
        if(binaryForm<0){
            x=1/x;
            binaryForm=-binaryForm;
        }

        long ans=1;
        while(binaryForm>0){
          if(binaryForm%2==1){
            ans=(ans*base)%M;
          }
          base=(base*base)%M;
          binaryForm/=2;
        }
        
        return (int)ans;
    }
    public static void main(String[] args) {
        int x=2;
        int n=4;
        int M=2;

        int res=PowMode(x,n,M);
        System.out.println(res);
        
    }
}
