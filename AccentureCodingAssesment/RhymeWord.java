public class RhymeWord {
    public static void main(String[] args){
        String word="thunder";

        String rhymeArr[]={"Blender","Powder","thunder","Shoulder"};

        //string suffixes to check
        int k=Math.min(3,word.length());
        String sufix=word.substring(word.length()-k);
        
        for(int i=0;i<rhymeArr.length;i++){
            for(int j=rhymeArr[i]-1;j>=sufix.length();j--){

            }
        }

    }
}
