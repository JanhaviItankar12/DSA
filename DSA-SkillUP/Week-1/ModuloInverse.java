public class ModuloInverse {
    static int modInverse(int a,int b){
        int OriginalM=b;
        int x0=1;
        int x1=0;
        
        while(b!=0){
            int q=a/b;
            int temp=b;
            b=a%b;
            a=temp;

            temp=x1;
            x1=x0-q*x1;
            x0=temp;

        }
        if(a!=1){
            return -1;
        }

        //  x0 may be negative, make it positive
        return (x0%OriginalM+OriginalM)%OriginalM;
    }

    public static void main(String[] args) {
        int a=28;
        int b=20;

        int inverse=modInverse(a,b);

    }
}
