
import java.util.ArrayList;

public class PatternSearching {

    static ArrayList<Integer> optimal(String s,String p){
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
       
         return result;
        
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

    static ArrayList<Integer> bruteForce(String s,String p){
        ArrayList<Integer> res=new ArrayList<>();


        int i=0;
        int j=p.length()-1;
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        int ans=0;
        while(i<p.length()-1 && j>0){
           s1.append(p.charAt(i));
           s2.append(p.charAt(j));
           if(s1==s2.reverse()){
             ans++;
           }
           i--;
           j++;
        }

        System.out.println(ans);
        return res;
        
    }
    
    public static void main(String[] args) {

         String s="pqpqpqr";
         String p="pqpq";
         ArrayList<Integer> list=new ArrayList<>();
        
         
         // optimal -approach
        list=optimal(s,p);

        
    }

   
    
}
