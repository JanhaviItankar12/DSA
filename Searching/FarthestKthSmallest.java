import java.util.ArrayList;

public class FarthestKthSmallest {
    static  ArrayList<Integer> BruteForce(int arr[],int n){
          ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<n-1;i++){
            int count=0;
            int idx=0;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    idx=Math.max(idx,j);
                    count++;
                }
            }
           
            if(count==0){
                list.add(-1);
            }
            else{
                list.add(idx);
            }

            
           
        }
        
        //add last index
        list.add(-1);
        return list;
    }

    static ArrayList<Integer> Optimized(int arr[],int n){
        ArrayList<Integer> list=new ArrayList<>();

        int suffixMinarr[]=new int[n];
        suffixMinarr[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
           suffixMinarr[i]=Math.min(arr[i],suffixMinarr[i+1]);
        }

        for(int i=0;i<n;i++){
            
            int st=i+1;
            int end=n-1;
            int ans=-1;
            while(st<=end){
                int mid=st+(end-st)/2;

                if(suffixMinarr[mid]<arr[i]){
                   ans=mid;
                   st=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            list.add(ans);
        }

        System.out.println(list);
        return list;
    }
    public static void main(String[] args) {
        int arr[]={2, 5, 1, 3, 2};
        int n=arr.length;
      
        ArrayList<Integer> list1=BruteForce(arr,n);

        ArrayList<Integer> list2=Optimized(arr,n);
       
        
       
    }
}
