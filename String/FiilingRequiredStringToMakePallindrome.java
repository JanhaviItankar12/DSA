public class FiilingRequiredStringToMakePallindrome {

    static int[] computeLPS(String concat){
        int n=concat.length();
        int lps[]=new int[n];
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<n){
            if(concat.charAt(i)==concat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String s="aacecaaaa";
        
        
        String revS=new StringBuilder(s).reverse().toString();
        String concat=s+'$'+revS;
        

        int lps[]=computeLPS(concat);

        for(int i=0;i<lps.length;i++){
            System.out.println(lps[i]);
        }
        int n=lps.length;
        

        int m=s.length()-lps[n-1];
        String charToAdd=revS.substring(0,m);
        
        String newS=charToAdd+s;
        System.out.println(newS);
        
        
    }
}
