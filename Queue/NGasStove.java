import java.util.*;
public class NGasStove {
    public static void main(String[] args) {
        
        int n=4;
        int M=9;
        int T=5;
        int recipes[]={3,5,6,7,8,3,4,5,6};
         
        //to pick min time recipes first to cook
        Arrays.sort(recipes);

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        //add free time for each stove now 0;
        for(int i=0;i<n;i++){
            pq.add(0);
        }
        
        int totalRecipe=0;
        for(int i=0;i<M;i++){

            int freeTime=pq.remove();  //pick minimum first for starting next recipe to cook

            if(recipes[i]+freeTime>T){
              break;
            }
            pq.add(recipes[i]+freeTime);
            totalRecipe++;

        }

        System.out.println(totalRecipe);
    }
}
