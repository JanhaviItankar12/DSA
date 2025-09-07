
import java.util.ArrayList;

public class localMinAndMaxSequence {
    public static void main(String[] args) {
        int arr[]={1,4,-1,5,8};
        int n=arr.length;

        ArrayList<Integer> list=new ArrayList<>();
        
        // step1:make compressed list

        list.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
               list.add(arr[i]);
            }
        }

        // step2:make new res list to add all elevation point

        ArrayList<Integer> res=new ArrayList<>();
        int m=list.size();

        res.add(list.get(0));

        for(int i=1;i<m-1;i++){
            if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
                res.add(list.get(i));
            }
            if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                res.add(list.get(i));
            }
        }

        if(m>1){
            res.add(list.get(m-1));
        }

        System.out.println(res);
    } 
}
