
import java.util.ArrayList;

public class PatternSearching {
    public static void main(String[] args) {
        // String s="abesdu";
        // String p="esdu";
        // int l1=s.length();
        // int l2=p.length();
        // int i=0;
        // int j=0;
        // boolean foundPattern=false;
        // ArrayList<Integer> result=new ArrayList<>();
        
        // // O(n*m)
        // while((i>=0 && i<l1) || (j>=0 && j<l2)){
           
           
        //     if(s.charAt(i)==p.charAt(j)){
        //         foundPattern=true;
        //         if(j==(l2-1) && foundPattern==true){
        //             result.add(i-j);
        //            if(i==l1-1){
        //              break;
        //            }
        //            else{
        //             j=0;
        //            }
        //         }
        //        else{
                
        //         i++;
        //         j++;
        //        }
               
        //     }
        //     else{
        //         i = i - j + 1;
        //         j=0;
        //         foundPattern=false;
        //     }
        // }

        // // If match ends at the very end
        //    if (j == l2 && foundPattern) {
        //      result.add(i - j);
        //     }

        // System.out.println(result);

        

         // optimal -approach

         String s="pqpqpqr";
         String p="pqpq";
         ArrayList<Integer> result=new ArrayList<>();

         int n=s.length();
         int m=p.length();

         int lps[]=computeLPS(p);

         int i=0;
         int j=0;

         while(i<n){

            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;

                if(j==m){
                  result.add(i-j);
                //   to avoid redundant occurences
                  j=lps[j-1];
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

         System.out.println(result);
        
    }

    static int[] computeLPS(String p){
        int m=p.length();
        int len=0;
        int lps[]=new int[m];
        lps[0]=0;
        int i=1;

        while(i<m){
            if(p.charAt(i)==p.charAt(len)){
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
