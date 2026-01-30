import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveFirstAndSecond{
    public static void main(String[] args) {
    
        Queue<Integer> q=new LinkedList<>();

        q.add(2);
        q.add(3);
        q.add(4);
        q.add(1);
        
        //arr for storing elements from queue
        int n=q.size();
        int arr[]=new int[n];
        int res[]=new int[n];
        
        
        int i=0;
        while(!q.isEmpty()){
            
            arr[i]=q.remove();
            // System.out.print(arr[i]);
            i++;
        }
        
        int mid=n/2;
        
        int j=0,k=mid,p=0;
        while(p<n && j<mid && k<n ){
           
           res[p]=arr[j];
        //    System.out.println(res[p]);
           p++;
           res[p]=arr[k];
        //    System.out.println(res[p]);
           j++;
           k++;
           p++;
            
        }
        
        for(int h=0;h<n;h++){
            q.add(res[h]);
        }

        System.out.println(q);
        


    }
}
