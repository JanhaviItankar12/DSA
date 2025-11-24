
import java.util.ArrayList;



public class RabinKarpAlgorithm
 {

    static boolean  algorithm(String s1,String s2,int n,int m){
         
        //take two prime no. as base and modulo
        int modulo=1000000007;  //for avoid overflow
        int base=256; //prime no

        String S=s1;
        
        //find first hash pattern
        int HashPat=0;
        for(int i=0;i<m;i++){
            HashPat=(HashPat*base+(s2.charAt(i)-'a'))%modulo;
        }

        //find power
        int power=1;
        for(int i=0;i<m-1;i++){
            power=(power*base)%modulo;
        }
        
        boolean found=false;

        //rolling to check for its hashing
        int i=0;
        int len=S.length();
        int HashS=0;
        int count=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<len){
            HashS=(HashS*base+S.charAt(i)-'a')%modulo;
            count++;
            i++;
            if(count==m){
                //check for Pattern of those strings
                if(HashPat==HashS){
                    int g=i-m;
                    boolean isEqual=true;
                    for(int d=0;d<m;d++){
                        if(s2.charAt(d)!=S.charAt(g)){
                            isEqual=false;
                        }
                        g++;
                    }
                    
                    if(isEqual){
                        list.add(i-m);
                        found=true;
                    }
                    
                }
             
                HashS=(HashS-(power*(S.charAt(i-m)-'a'))%modulo+modulo)%modulo;
                count=m-1;
                
            }
            
           
        }
        

        System.out.println(list);
        return found;
    }
    //given two string we have to check is s2 rotate version of s1 -here we are applying rabin karp algorithm which is for pattern searching
    public static void main(String[] args) {
        String s1="ababa";
        String s2="aba";

        int n=s1.length();
        int m=s2.length();

        boolean res=algorithm(s1,s2,n,m);
        System.out.println(res);
       
        
       
        

    }
}
