import java.util.ArrayList;
import java.util.Collections;

class item{
    int val;
    int wt;
    double ratio;

    public item(int val,int wt){
         this.val= val;
         this.wt=wt;
         this.ratio=(double) val/wt;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[]={1,5,7,2,7,10};
        int wt[]={4,9,6,3,7,3};
        int capacity=24;
        int n=val.length;

        ArrayList<item> item=new ArrayList<>();

        for(int i=0;i<n;i++){
            item.add(new item(val[i],wt[i]));
        }

        Collections.sort(item,(a,b)->Double.compare(b.ratio, a.ratio));
        
        double totalValue=0;
        int weight=0;
        for(int i=0;i<n;i++){
           if(weight+item.get(i).wt<=capacity){
             totalValue+=item.get(i).val;
             weight+=item.get(i).wt;
            
           }
           else{
             
              totalValue=totalValue+(double)((capacity-weight)*item.get(i).val)/item.get(i).wt;
              weight+=(capacity-weight);
              break;
           }
        }

        System.out.println(totalValue);

        

    }
}
