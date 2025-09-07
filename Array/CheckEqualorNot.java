public class CheckEqualorNot {
    public static void main(String[] args) {
        int a[]={1,1,1,1};
        int b[]={1,1,1,1};

        int n=a.length;
        int m=b.length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]==b[j]){
                    count++;
                    break;
                }
            }
        }

        if(count==n){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
