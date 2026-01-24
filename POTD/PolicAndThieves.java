import java.util.ArrayList;

public class PolicAndThieves {
    public static void main(String args[]) {
        char arr[]={'P','T','T','P','T'};
        int k=1;
        int caught=0;
        int n=arr.length;

        ArrayList<Integer> police=new ArrayList<>();
        ArrayList<Integer> thieves=new ArrayList<>();
       
       
        for(int i=0;i<n;i++){
             if(arr[i]=='P'){
                police.add(i);
             }
             else{
                thieves.add(i);
             }
        }

        int m=0,p=0;
        while(m<police.size() && p<thieves.size()){

            if(Math.abs(police.get(m)-thieves.get(p))<=k){
                caught++;
                m++;
                p++;
            }
            else if(thieves.get(p)<police.get(m)){
                p++;
            }
            else{
                m++;
            }
        }

        
        System.out.println(caught);



    }
}
