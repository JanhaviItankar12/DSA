public class StringDecoder {
    public static void main(String[] args){
      
        String str="010011100110";
        int n=str.length();
        StringBuilder res=new StringBuilder();

        for(int i=0;i<n;i++){

            if(str.charAt(i)=='0'){
               continue;
            }
            else{  //'1'
               int count=0;
               while(i<n && str.charAt(i)=='1'){
                 i++;
                 count++;
               }
               
               if(count>=1 && count<=26){
                 char decodedChar=(char)('A'+count-1);
                 res.append(decodedChar);
               }
               i--;

            }


        }

        System.out.println(res);
    }
}
