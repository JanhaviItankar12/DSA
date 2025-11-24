public class ValidateAnIPAddress {
    static boolean checkValidity(String s,int n){
        int i=0;
        int count=0;
        while(i<n && count<=4){
           int m=i;
           while(i<n && s.charAt(i)!='.') {
             i++;
           }
           
           String str=s.substring(m, i);
           if(str.length()>1 && str.charAt(0)=='0'){
               return false;
           }
           int num=Integer.parseInt(str);
           if(num<0 || num>255){
             return false;
           }
           
           int dotCount=0;
           while(i<n && s.charAt(i)=='.'){
             dotCount++;
             i++;
           }

           if(dotCount>1){
             return false;
           }
           count++;
        }

        if(count!=4){
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s="01.01.01.01";
        int n=s.length();

        boolean res=checkValidity(s, n);
        System.out.println(res);

       

    }
}
