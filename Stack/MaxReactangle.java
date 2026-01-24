
import java.util.Stack;

public class MaxReactangle {

    public static int histogram(int h[],int arr[]) {
        
        int n=arr.length;
        int ans=0;

        //make max height of reactangle  w.r.t 1s
        for(int i=0;i<n;i++){
           if(arr[i]==1){
              h[i]++;
           }
           else{
             h[i]=0;
           }
        }

        
        
        //find left and right smaller boundareis
        int right[]=new int[n];
        Stack<Integer> rst=new Stack<>();

        for(int i=0;i<n;i++){

            while(!rst.isEmpty() && h[i]<h[rst.peek()]){
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

            while(!lst.isEmpty() && h[i]<h[lst.peek()]){
                left[lst.peek()]=i;
                lst.pop();
            }
            lst.push(i);
        }

        while(!lst.isEmpty()){
            left[lst.peek()]=-1;
            lst.pop();
        }

        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int maxArea=h[i]*width;
            ans=Math.max(ans,maxArea);
        }

       

        return ans;
        
    }
    public static void main(String[] args) {
        
        int mat[][]={
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0}
        };

        int row=mat.length;
        int col=mat[0].length;

        //height array
        int h[]=new int[col];
        int maxArea=0;


        for(int i=0;i<row;i++){

            int arr[]=new int[row];
            for(int j=0;j<col;j++){
               arr[j]=mat[i][j];
            }

            //use as histogram and find max ractangle
            int area=histogram(h,arr);
            maxArea=Math.max(maxArea,area);
        }

        

        System.out.println(maxArea);

    }
}
