import java.util.*;

public class SubArrayRanges {
    public static void main(String[] args) {
        
        int arr[]={1,3,2};
        int n=arr.length;

        //rightGreater and leftGreater find for each element
        Stack<Integer> rst=new Stack<>();
        int rightGreat[]=new int[n];

        for(int i=0;i<n;i++){

            while(!rst.isEmpty() && arr[i]>=arr[rst.peek()]){
                rightGreat[rst.peek()]=i;
                rst.pop();
            }

            rst.push(i);
        }

        while(!rst.isEmpty()){
            rightGreat[rst.peek()]=n;
            rst.pop();
        }


        Stack<Integer> lst=new Stack<>();
        int leftGreat[]=new int[n];

        for(int i=n-1;i>=0;i--){

            while(!lst.isEmpty() && arr[i]>arr[lst.peek()]){
                leftGreat[lst.peek()]=i;
                lst.pop();
            }

            lst.push(i);
        }

        while(!lst.isEmpty()){
            leftGreat[lst.peek()]=-1;
            lst.pop();
        }

        Stack<Integer> rstSm=new Stack<>();
        int rightSmall[]=new int[n];

        for(int i=0;i<n;i++){

            while(!rstSm.isEmpty() && arr[i]<=arr[rstSm.peek()]){
                rightSmall[rstSm.peek()]=i;
                rstSm.pop();
            }

            rstSm.push(i);
        }

        while(!rstSm.isEmpty()){
            rightSmall[rstSm.peek()]=n;
            rstSm.pop();
        }

        Stack<Integer> lstSm=new Stack<>();
        int leftSmall[]=new int[n];

        for(int i=n-1;i>=0;i--){

            while(!lstSm.isEmpty() && arr[i]<arr[lstSm.peek()]){
                leftSmall[lstSm.peek()]=i;
                lstSm.pop();
            }

            lstSm.push(i);
        }

        while(!lstSm.isEmpty()){
            leftSmall[lstSm.peek()]=-1;
            lstSm.pop();
        }


        //find countMax and countMin
        int countMax[]=new int[n];
        int countMin[]=new int[n];
        for(int i=0;i<n;i++){
            countMax[i]=(rightGreat[i]-i)*(i-leftGreat[i]);
            countMin[i]=(rightSmall[i]-i)*(i-leftSmall[i]);
            
        }
        

        //calcuate final ans
        int ans=0;
        for(int i=0;i<n;i++){

            int contribution=arr[i]*(countMax[i]-countMin[i]);
            ans+=contribution;

        }

        System.out.println(ans);


       


    }
}
