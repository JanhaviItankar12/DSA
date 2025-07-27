public class StringRotationOfEachOther {
    public static void main(String args[]){
        String s1="abaa";
        String s2="aaba";
        int n=s2.length();

        String combined=s2+s2;
        System.out.println(result(combined, s1));

        // brute force-approach
        // boolean isEqual=false;
        // for(int i=0;i<n;i++){
        //     String sub=rotatedStr.substring(i,i+n);
        //     if(sub.equals(s1)){
        //        isEqual=true;
        //     }
        // }

        // if(isEqual){
        //     System.out.println(true);
        // }
        // else{
        //     System.out.println(false);
        // }



    }

    static boolean result(String combined,String s1){
        int lps[]=computeLPS(s1);
        int i=0;
        int j=0;
        int n=combined.length();
        int m=s1.length();
        
        while(i<n){
            if(combined.charAt(i)==s1.charAt(j)){
                i++;
                j++;
                if(j==m){
                    return true;
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
        return false;
    }
    
    static int[] computeLPS(String s1){
        int n=s1.length();
        int lps[]=new int[n];
        int len=0;
        lps[0]=0;
        int i=1;
        
        while(i<n){
            if(s1.charAt(i)==s1.charAt(len)){
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
}
