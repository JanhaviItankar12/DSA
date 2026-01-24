
public class LongestPallindrome {
    public static void main(String[] args) {
        String s="abacac";
        
        int n=s.length();
        

        StringBuilder str=new StringBuilder();
       
        //add @ first
        str.append('@');
        
        int i=0;
        while(i<n){
            str.append('#');
            str.append(s.charAt(i));
            i++;
        }
          
        str.append('#');
        str.append('@');
       

        //calculate longest pallindromic string length;
        int m=str.length();
        
        int lenArr[]=new int[m];
        for(int j=1;j<m-2;j++){
           
            while(str.charAt(j+1+lenArr[j])==str.charAt(j-1-lenArr[j])){
                lenArr[j]++;
            }
        }

        

        int largest=lenArr[0];
        int index=-1;

        for(int k=0;k<lenArr.length;k++){
           
            if(lenArr[k]>largest){
                largest=lenArr[k];
                index=k;
            }
        }
        
        // System.out.println(index);
        
        int orgIdx=(index-2)/2;
        int st=(largest/2)-orgIdx;

        StringBuilder s1=new StringBuilder();

        int count=1;
        while(count<=largest){
           s1.append(s.charAt(st));
           st++;
           count++;
        }

        System.out.println(s1);


       



      



    }
}
