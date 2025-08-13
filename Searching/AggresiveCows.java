import java.util.Arrays;

public class AggresiveCows {

      static boolean possibleAns(int stalls[],int mid,int k,int n){
        int cow=1;
        int lastPos=stalls[0];
        
        for(int i=1;i<n;i++){
            if(stalls[i]-lastPos>=mid){
                cow++;
                lastPos=stalls[i];
            }
            
            if(cow==k){
                return true;
            }
        }
        
        return false;
        
        
    }
    public static void main(String[] args) {
        int stalls[]={1,8,4,9,3};
        int k=4;
         // sort array
        Arrays.sort(stalls);
        int n=stalls.length;
        
        int low=1; //minimum possible dist between cows
        int high=stalls[n-1]-stalls[0];
        
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(possibleAns(stalls,mid,k,n)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else{
              high=mid-1;  
            }
        }
        
       System.out.println(ans);
    }
}
