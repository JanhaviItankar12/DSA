import java.util.Stack;

public class MaximumVisibleInLines {
    public static void main(String[] args) {
        
        int arr[]={6 ,2 ,5 ,4, 5, 1, 6};
        int n=arr.length;

        //find nextGreater from left and right
        int right[]=new int[n];
        Stack<Integer> rst=new Stack<>();

        for(int i=0;i<n;i++){

            while(!rst.isEmpty() && arr[i]>=arr[rst.peek()]){
                right[rst.peek()]=i;
                rst.pop();
            }
            rst.push(i);
        }
        while(!rst.isEmpty()){
            right[rst.peek()]=n;
            rst.pop();
        }

        int left[]=new int[n];
        Stack<Integer> lst=new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(!lst.isEmpty() && arr[i]>=arr[lst.peek()]){
                left[lst.peek()]=i;
                lst.pop();
            }
            lst.push(i);
        }
        while(!lst.isEmpty()){
            left[lst.peek()]=-1;
            lst.pop();
        }

        int ans=0;
        for(int i=0;i<n;i++){
          ans=Math.max(ans,right[i]-left[i]-1);
        }

        System.out.println(ans);
    }
}
