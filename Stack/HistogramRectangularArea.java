import java.util.*;

public class HistogramRectangularArea {
    public static void main(String[] args) {
        int arr[]={60,20,50,40,10,50,60};

        int n=arr.length;

        //find right nearest smallest value
        Stack<Integer> rst=new Stack<>();
        ArrayList<Integer> rightSmall=new ArrayList<>();

        for(int i=n-1;i>=0;i--){

            if(rst.isEmpty()){
               rst.push(i);
               rightSmall.add(n);  //for calculating correct width
            }
            else{

                while(!rst.isEmpty()  && arr[rst.peek()]>=arr[i]){
                    rst.pop();
                }

                if(rst.isEmpty()){
                   rst.push(i);
                   rightSmall.add(n);   //for calculating correct width
                }
                else{
                    rightSmall.add(rst.peek());
                    rst.push(i);
                }
            }
        }


        Collections.reverse(rightSmall);
        System.out.println(rightSmall);


        //left small nearest element
        Stack<Integer> lst=new Stack<>();
        ArrayList<Integer> leftSmall=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(lst.isEmpty()){
               lst.push(i);
               leftSmall.add(-1);  //for calculating correct width
            }
            else{

                while(!lst.isEmpty()  && arr[lst.peek()]>=arr[i]){
                    lst.pop();
                }

                if(lst.isEmpty()){
                   lst.push(i);
                   leftSmall.add(-1);   //for calculating correct width
                }
                else{
                    leftSmall.add(lst.peek());
                    lst.push(i);
                }
            }
        }


        
        System.out.println(leftSmall);


        int ans=0;
        for(int i=0;i<n;i++){

           
            int currArea=arr[i]*(rightSmall.get(i)-leftSmall.get(i)-1);
            ans=Math.max(ans,currArea);
        }

        System.out.println(ans);
    }
}
