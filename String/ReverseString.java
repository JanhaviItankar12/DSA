public class ReverseString {
    public static void main(String[] args) {
        String s="..home....";
        int n=s.length();
       

        StringBuilder str=new StringBuilder();

        //leading dots
        int j=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='.'){
                break;
            }
            j++;
        }

        //trailing dots
        int k=n-1;
        for(int i=n-1;i>=j;i--){
          if(s.charAt(i)!='.'){
            break;
          }
          k--;
        }
        
        
         

        int i=k;
        while(i>=j){
            
            int m=i;
            int prev=i+1;
            while( i>=j && s.charAt(i)!='.' ){
               prev=i;
               i--;
            }
            
            
            for(int p=prev;p<=m;p++){
                str.append(s.charAt(p));
            }
            
            
            int dotCount=0;
            while( i>=j && s.charAt(i)=='.'){
               i--;
               dotCount++;
            }

            if(dotCount>=1){
                str.append('.');
            }

           

        }

        System.out.println(str);



        
    }
}
