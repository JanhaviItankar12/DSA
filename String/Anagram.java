public class Anagram {
    public static void main(String[] args) {
        String s="aad";
        String t="aad";

        int count[]=new int[26];
        boolean isAnagram=true;

        if(s.length()!=t.length()){
           System.out.println(false);
        }

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
               isAnagram=false;
            }
        }

        if(isAnagram){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

       
    
    }
}
