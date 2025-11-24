import java.util.ArrayList;

public class SearchInSubArray {

    static int[] computeLPS(int b[],int m){
        int lps[]=new int[m];

        lps[0]=0;
        int i=1;
        int len=0;

        while(i<m){
            if(b[len]==b[i]){
                len++;
                b[i]=len;
                i++;
            }
            else{
                if(len==0){
                    lps[i]=len;
                    i++;
                }
                else{
                    len=lps[len-1];
                }
            }
        }

        return lps;
    }
    public static void main(String[] args) {
        int arr[]={1,2,1,2,1,2,1,2};
        int subArr[]={1};

        int n=arr.length;
        int m=subArr.length;

        int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        int lps[]=computeLPS(subArr, m);

        while(i<n && j<m){
           if(arr[i]==subArr[j]){
              i++;
              j++;

              if(j==m){
                list.add(i-j);

                j=lps[j-1];
              }
             
           }
           else{
             if(j!=0){
                j=lps[j-1];
             }
             else{
                i++;
             }
           }
        }

        System.out.println(list);
    }
}
