
public class MinimumSmallestKProductOfTwoSortedArrays {
    public static void main(String[] args) {
        int a[]={2,3};
        int b[]={4,5};
        int k=2;

        //  bruteForce approach
        // ArrayList<Integer> list=new ArrayList<>();

        // for(int i=0;i<a.length;i++){
        //     for(int j=0;j<b.length;j++){
        //         list.add(a[i]*b[j]);
        //     }
        // }

        

        // Collections.sort(list);
        // System.out.println(list);
        // System.out.println(list.get(k-1));

        // optimized approach

        int n=a.length;
        int m=b.length;
        int st=0;
        int end=0;

        if(a[0]>0 && b[0]>0){
             st=a[0]*b[0];
             end=a[n-1]*b[n-1];
        }
        else if(a[0]<0 && b[0]>0){
            st=a[0]*b[n-1];
            end=a[n-1]*b[0];

        }
        else if(a[0]>0 && b[0]<0){
           st=a[n-1]*b[0];
          end=a[0]*b[n-1];
        }
        else if(a[0]<0 && b[0]<0){
            st=a[n-1]*b[n-1];
            end=a[0]*b[0];
        }
        else if(a[0]==0 || b[0]==0){
             st=0;
             end=a[n-1]*b[n-1];
        }

        while(st<=end){
           int mid=st+(end-st)/2;

           if(possibleAns(mid)){
             ans=mid;
           }
        }

    }
}
