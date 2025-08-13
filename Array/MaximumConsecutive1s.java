public class MaximumConsecutive1s {

    static int NaiveApproach(int arr[],int n,int k){
        //step1:iniitially count consecutive of 1's
        int count1=1;
        int count2=0;
        
        for(int i=0;i<n-1;i++){
            if(arr[i]==1 && arr[i+1]==1){
                count1++;
            }
            else if(arr[i]==0 && arr[i+1]==1){
                if(i!=0){
                    count2=Math.max(count2,count1);
                    count1=0;
                    count1++;
                }
                else {
                    count1=1;
                }
            }
            else{
                count2=Math.max(count2,count1);
                count1=0;
            }
        }
        
        int max=Math.max(count2,count1);
        
        // step2:change 0 to 1
        int max2=0;
        int flipCount=k;
        int j=0;
        
        while(j<n){
            if(arr[j]==0 && flipCount>0){
                arr[j]=1;
                j++;
                flipCount--;
                count1=1;
                count2=0;
                 for(int i=0;i<n-1;i++){
            if(arr[i]==1 && arr[i+1]==1){
                count1++;
            }
            else if(arr[i]==0 && arr[i+1]==1){
                if(i!=0){
                    count2=Math.max(count2,count1);
                    count1=0;
                    count1++;
                }
                else {
                    count1=1;
                }
            }
            else{
                count2=Math.max(count2,count1);
                count1=0;
            }
        }
                max2=Math.max(count2,count1);
                
            }
            else if(flipCount==0){
                flipCount=k;
            }
        }
        
        return Math.max(max,max2);

    }
    public static void main(String[] args) {
        int arr[]={1,0,1,0,0,1,1,1,1,1};
        int n=arr.length;
        int k=2;  //at most flip

    //    int res=NaiveApproach(arr, n, k);  //it wrongs some how
    //    System.out.println(res);


       //optimized approach-sliding window
       int left=0;
      
       int zc=0;
       int maxLen=0;

       for(int right=0;right<n;right++){
        if(arr[right]==0){
            zc++;
        }
        while(zc>k){
           if(arr[left]==0){
              zc--;
           }
           left++;
        }

        maxLen=Math.max(maxLen,right-left+1);
       }

       System.out.println(maxLen);
        

      
       

        
    }
}
