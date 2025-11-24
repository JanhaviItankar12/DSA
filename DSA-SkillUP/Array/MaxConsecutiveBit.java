public class MaxConsecutiveBit {
    public static  void main(String args[]){
        int arr[]={0,1,0,1,1,1};
        int n=arr.length;

        int count1=0;
        int count0=0;
        int ans=0;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                if(count0>0){   //it check for if consecutive 0's break by 1
                  count0=0;
                  count1=1;
                }
                else{    //it for consecutive 1's
                    count1++;
                    ans=Math.max(ans,count1);
                }
                
            }
            else{
                if(count1>0){  //it check if consecutive 1's break by 0's
                  count1=0;
                  count0=1;
                }
                
                else{  //it for consecutive 0's
                    count0++;
                    ans=Math.max(ans,count0);
                }
            }
        }

        System.out.println(ans);


    }
}
