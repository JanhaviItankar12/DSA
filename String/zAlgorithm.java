public class zAlgorithm {
    public static void main(String[] args) {
        String s="aaabcd";

        int n=s.length();

        int L=0;
        int R=0;
        int z[]=new int[n];

        for(int i=1;i<n;i++){

            if(i>R){
                L=i;
                R=i;

                while(R<n && s.charAt(R-L)==s.charAt(R)){
                    R++;
                }
                z[i]=R-L;
                R--;
            }
            else{   //i<=R
               int k=i-L;

               if(z[k]<R-i+1){
                  z[i]=z[k];
               }
               else{
                  L=i;
                  while(R<n && s.charAt(R-L)==s.charAt(R)){
                    R++;
                  }
                  z[i]=R-L;
                  R--;
               }
            }
        }

       

        int longest=0;
        int maxZ=0;

        for(int i=1;i<n;i++){
            if(z[i]+i==n){
                if(maxZ>=z[i]){
                    longest=z[i];
                }
            }
            maxZ=Math.max(maxZ,z[i]);

        }

        System.out.println(longest);

    }
}
