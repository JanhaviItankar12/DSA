public class NonRepeatedCharacterFirst {
    public static void main(String[] args) {
        
    
     int count[]=new int[26];
     String s="geekgeeks";
        
        // O(n)
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1){
               System.out.println(s.charAt(i));
            }
        }
        
       
    }
}
