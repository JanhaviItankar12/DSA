
import java.util.ArrayList;

public class MinimumNoOfWorkers {

    public static void Optimal(int arr[]){

        int n=arr.length;
        int maxReach[]=new int[n];

        for(int i=0;i<n;i++){

            if(arr[i]==-1){
                return;
            }

            int left=Math.max(0,i-arr[i]);
            int right=Math.min(n-1,i+arr[i]);

            maxReach[left]=Math.max(maxReach[left],right);
        }

        int currentEnd=0;
        int farthest=0;
        int workers=0;

        for(int i=0;i<n-1;i++){

            if(i>farthest){
                return;
            }

            farthest=Math.max(farthest,maxReach[i]);

            if(i==currentEnd){
                workers++;
                currentEnd=farthest;
            }
        }

        System.out.println(workers);
    }
   public static void main(String args[]) {

       int arr[]={1 ,0, 1 ,1,-1};
       int workers=0;
       int n=arr.length;
       ArrayList<int []> intervals=new ArrayList<>();

       for(int i=0;i<n;i++){

           if(arr[i]==-1){
              continue;
           }
           int leftRange=Math.max(0,i-arr[i]);
           int rightRange=Math.min(n-1,i+arr[i]);

           intervals.add(new int[]{leftRange,rightRange});

           
       }

       intervals.sort((a,b)->a[0]-b[0]);

       int coveredArea=0;
       int i=0;
       while(coveredArea<n){
           
           int farthest=coveredArea;
           while(i<intervals.size()  && intervals.get(i)[0]<=coveredArea){
              farthest=Math.max(farthest,intervals.get(i)[1]+1);
              i++;
           }

           if(farthest==coveredArea){
               return;
           }

           workers++;
           coveredArea=farthest;
       }

    //    System.out.println(workers);

       Optimal(arr);
   }
}
