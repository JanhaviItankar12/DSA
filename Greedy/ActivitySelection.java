
import java.util.*;


class Activity{
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
        
    }

public class ActivitySelection {
    public static void main(String[] args) {
        int start[]={1,3,0,8,5};
        int finish[]={2,4,6,9,9};

        int n=start.length;
        
        List<Activity> activity=new ArrayList<>();

        for(int i=0;i<n;i++){
            activity.add(new Activity(start[i], finish[i]));
        }

        Collections.sort(activity,Comparator.comparing(a->a.finish));

        int lastActivity=activity.get(0).finish;
        int count=1;

        for(int i=1;i<n;i++){
           if(activity.get(i).start>=lastActivity){
              count++;
              lastActivity=activity.get(i).finish;
           }
        }

        System.out.println(count);
    }
}
