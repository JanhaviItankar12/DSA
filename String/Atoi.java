public class Atoi {
    public static void main(String[] args) {
        String s="-aa788";
        int i=0;
        int n=s.length();
         
         
        // step1:check for string -empty
        if(s == null || n==0){
           System.out.println(0);
        }
        
        //step2: ignore spaces
        while(i<n && s.charAt(i) == ' ')  i++;
        
        // step3:handle sign
        int sign=1;
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign=(s.charAt(i) == '-')?-1:1;
            i++;
        }
        
        // step4:parse digits
        long num=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            num=num*10+(s.charAt(i)-'0');
            
            // step5:check for max and min value
            if(sign==1 && num>Integer.MAX_VALUE) System.out.println(Integer.MAX_VALUE);;
            if(sign==-1 && -num<Integer.MIN_VALUE) System.out.println(sign*Integer.MIN_VALUE);
            
            i++;
        }
        
       System.out.println((int)(sign*num));
    }
}
