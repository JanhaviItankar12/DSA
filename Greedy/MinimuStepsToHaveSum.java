import java.util.ArrayList;
import java.util.Collections;

public class MinimuStepsToHaveSum {
    public static void main(String[] args) {
        int arr[]={17,23,1,10};
        int n=arr.length;
        double sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        

        double half=(double)sum/2;
        int operation=0;
         
        ArrayList<Double> list=new ArrayList<>();
          for(int j=0;j<n;j++){
             list.add((double)arr[j]);
          }


        for(int i=0;i<n;i++){

          //sorting
          Collections.sort(list,Collections.reverseOrder());
          
          sum-=list.get(0);
          sum+=list.get(0)/2;
          list.set(0, list.get(0)/2);
          System.out.println(list);
          operation++;

          if(sum<=half){
            System.out.println("true");
            break;
          }



        }

        System.out.println(operation);
        
    }
}
