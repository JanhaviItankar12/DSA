public class AddTwoBinaryString{
     public static void main(String[] args) {
        String s1="100";
        String s2="100";
        int i=s1.length()-1;
        int j=s2.length()-1;
        
        StringBuilder s=new StringBuilder();
        int carry=0;
        
        while(i>=0 || j>=0 || carry!=0){
            
            int bit1=i>=0 ? s1.charAt(i--) -'0' : 0;
            int bit2=j>=0 ? s2.charAt(j--) -'0' : 0;
            
            int sum=bit1+bit2+carry;
            s.append(sum%2);
            carry=sum/2;
        }
        
        
        
        String res= s.reverse().toString();
        
        // can be way to ingnore leading zeros-00100=100
        // return res.replaceFirst("^0+(?!$)","");
        int idx=0;
        while(idx<res.length() && res.charAt(idx)=='0'){
            idx++;
        }
        
        System.out.println(res.substring(idx));
        
     }
}