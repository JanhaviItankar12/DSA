public class MinimumRepeatToMakeSubstring {

    static int[] computeLps(String s2,int m){

        int lps[]=new int[m];
        int len=0;
        int i=1;
        lps[0]=0;

        while(i<m){
            if(s2.charAt(i)==s2.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=len;
                    i++;
                }
            }
        }

        return lps;
    }
    public static void main(String args[]){
        String s1="abac";
        String s2="cabaca";

        int n=s1.length();
        int m=s2.length();
        
       
        
        int lps[]=computeLps(s2,m);
        
        int i=0;
        int j=0;
        while(i<n*(m/n+2)){
            if(s1.charAt(i % n) == s2.charAt(j)){
                i++;
                j++;

                if(j==m){
                    int count=(i+n-1)/n;
                    System.out.println(count);
                    break;
                }
               
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        
       
        
    }
}
