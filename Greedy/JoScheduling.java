import java.util.ArrayList;
import java.util.Collections;

class job{
    int deadline;
    int profit;

    public job(int deadLine,int profit){
        this.deadline=deadLine;
        this.profit=profit;
    }
}
public class JoScheduling {
    public static void main(String[] args) {
        
        int deadLine[]={4,1,1,1};
        int profit[]={20,10,40,30};
        
        int n=deadLine.length;
        int maxDeadline=deadLine[0];
        for(int i=1;i<n;i++){
            if(maxDeadline<deadLine[i]){
               maxDeadline=deadLine[i];
            }
        }

        
        boolean slot[]=new boolean[maxDeadline+1];

        ArrayList<job> jobs=new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new job(deadLine[i],profit[i]));
        }

        //sort
        Collections.sort(jobs,(a,b)->Integer.compare(b.profit, a.profit));
        
        int countJobs=0;
        int totalProfit=0;
        for(int i=0;i<n;i++){
            for(int j=jobs.get(i).deadline;j>0;j--){
                if(!slot[j]){
                   slot[j]=true;
                   countJobs++;
                   totalProfit+=jobs.get(i).profit;
                   break;
                }
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        res.add(countJobs);
        res.add(totalProfit);
        System.out.println(res);




    }
}
