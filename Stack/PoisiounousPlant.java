import java.util.Stack;

public class PoisiounousPlant {
    public static void main(String[] args) {
        int arr[]={3,5,6,34,5,6,4};
        int n=arr.length;

        int maxDays=0;

        //store pesticide and days to dies
        Stack<int []> st=new Stack<>();

        for(int i=0;i<n;i++){
            
            int days=0;  //every plant will survive

            while(!st.isEmpty() && arr[i]<=st.peek()[0]){
                days=Math.max(days,st.peek()[1]);
                st.pop();
            }

            if(st.isEmpty()){
                days=0;  //only he will survive till last
            }
            else{
                days=days+1;
            }

            maxDays=Math.max(maxDays,days);
            st.push(new int[]{arr[i],days});
        }

        System.out.println(maxDays);

    }
}
