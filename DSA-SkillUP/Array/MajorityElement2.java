
import java.util.ArrayList;

public class MajorityElement2 {
    public static void main(String[] args) {
        int arr[]={1,2,1,2,1,3,3,2};
        int n=arr.length;
        int count1=0;
        int count2=0;
        int cand1=0;
        int cand2=0;

        for(int i=0;i<n;i++){
            if(cand1==arr[i]){
                count1++;
            }
            else if(cand2==arr[i]){
                count2++;
            }
            else if(count1==0){
                cand1=arr[i];
                count1++;
            }
            else if(count2==0){
                cand2=arr[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

       

        for(int i=0;i<n;i++){
            if(cand1==arr[i]){
                count1++;
            }
            else if(cand2==arr[i]){
                count2++;
            }
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        if(count1>n/3){
            list.add(cand1);
        }
        if(count2>n/3){
            list.add(cand2);
        }

        System.out.println(list);
    }
}
