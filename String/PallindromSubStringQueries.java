
import java.util.ArrayList;

public class PallindromSubStringQueries {



    static int[] bruteForce(String s, int n, int queries[][]){
         
        int len=queries.length;



        int i=0;

        int res[]=new int[len];

        while(i<len){
            int left=queries[i][0];
            int right=queries[i][1];
            
            boolean  isPallindrome=true;
            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){
                   isPallindrome=false;
                   break;
                }
                left++;
                right--;
            }

            if(isPallindrome){
               res[i]=1;
            }

            i++;
            
        }

        for(int j=0;j<len;j++){
            System.out.println(res[j]);
        }

        return res;
    }

    
    
    static int[] manacherAlgo(String s,int n){
        
        StringBuilder str=new StringBuilder();
        
        str.append('@');
        
        for(int i=0;i<n;i++){
            str.append('#');
            str.append(s.charAt(i));
        }
        
        str.append("#@");
        
        int m=str.length();
        int lps[]=new int[m];
        
        int c=0;
        int r=0;
        for(int i=1;i<m-1;i++){
            
            int mirror=c-(i-c);
            
            if(i<r){
                lps[i]=Math.min(lps[mirror],r-i);
            }
            
            while(i+1+lps[i]<m-1 && i-1-lps[i]>=0 && str.charAt(i+1+lps[i])==str.charAt(i-1-lps[i])){
                lps[i]++;
            }
            
            if(i+lps[i]>r){
                c=i;
                r=i+lps[i];
            }
        }
        
        return lps;
        
    }
    static  ArrayList<Integer> palQueries(String s, int[][] queries) {
        // code here
        
        int n=s.length();
        int len=queries.length;
        
        int lps[]=manacherAlgo(s,n);
        
        ArrayList<Integer> list=new ArrayList<>();
        
        int i=0;
        while(i<len){
            
            int st=queries[i][0];
            int end=queries[i][1];
            
            int lenStr=end-st+1;
            int mid=(end+st)/2;
            
            int center;
            if(lenStr % 2 == 1) {
                // Odd length: center is at the middle character
                center = 2 * ((st + end) / 2) + 2;
            } else {
                // Even length: center is between two middle characters  
                center = 2 * ((st + end) / 2) + 3;  // or center = st + end + 3
            }
            
            if(lps[center]>=lenStr){
                list.add(1);
            }
            else{
                list.add(0);
            }
            
            i++;
        }
        
        return list;
    }

    public static void main(String[] args) {
        String s="abaaabaaaba";
        int n=s.length();

        int queries[][]={{0,10},{5,8},{2,5},{5,9}};

        // int res[]=bruteForce(s,n,queries);

        ArrayList<Integer> list=palQueries(s,queries);

        System.out.println(list);


        
       




    }
}
