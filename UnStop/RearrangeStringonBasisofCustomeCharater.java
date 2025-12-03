
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RearrangeStringonBasisofCustomeCharater {
    public static void main(String[] args) {
        String S="xzzzzxyyzzeaze";
        String T="xyz";

       
        StringBuilder str=new StringBuilder();
        Boolean checkArray[]=new Boolean[S.length()];

        int i=0;
        while(i<T.length()){
            
            for(int j=0;j<S.length();j++){
                if(S.charAt(j)==T.charAt(i)){
                   
                    str.append(T.charAt(i));
                    checkArray[j]=true;
                }
            }
            
            i++;
        }
        
        Map<Character,Integer> count=new HashMap<>();
        ArrayList<Character> order =new ArrayList<>();

        for(int k=0;k<S.length();k++){
           
            if(checkArray[k]==null){
                char c=S.charAt(k);
                count.put(c,count.getOrDefault(c, 0)+1);
                if(!order.contains(c)){
                    order.add(c);
                }
            }
        }

        for (char c : order) {
          for (int k = 0; k < count.get(c); k++) {
            str.append(c);
          }
        }


        S=str.toString();
        System.out.println(S);


        

        


    }
}
