public class KthElementOfTwoArray {
    // static int merge(int a[],int b[],int k){
    //     int n=a.length;
    //     int m=b.length;
    //     int temp[]=new int[n+m];
    //     int l=0;

    //     int i=0;
    //     int j=0;

    //     while(i<n && j<m ){
    //         if(a[i]<=b[j]){
    //             temp[l]=a[i];
    //             i++;
    //             l++;
    //         }  
    //         else{
    //             temp[l]=b[j];
    //             j++;
    //             l++;
                
    //         }
    //     }

    //     while(i<n){
    //         temp[l]=a[i];
    //             i++;
    //             l++;
                
    //     }

    //     while(j<m){
    //          temp[l]=b[j];
    //             j++;
    //             l++;
                
    //     }

    //    if(temp.length%2==0){
    //      int mid=0+(temp.length-0)/2;
    //      return (temp[mid]+temp[mid+1])/2;
    //    }
    //    else{  //odd length
    //       int mid=0+(temp.length-0)/2;
    //       return temp[mid];
    //    }
    // }

    static int findKthElement(int a[],int b[],int k){
       
        // code here
        int n=a.length;
        int m=b.length;
        
        if(m<n){
            return findKthElement(b, a, k);
        }
        
        int l=0;
        int h=n;
        
        while(l<=h){
            int m1=(l+h)/2;
            int m2=k-m1; //for finding k th position 
            
            int l1=(m1==0) ? (Integer.MIN_VALUE) : a[m1-1];
            int r1=(m1==n) ? (Integer.MAX_VALUE) : a[m1];
            int l2=(m2==0) ? (Integer.MIN_VALUE) : b[m2-1];
            int r2=(m2==m) ? (Integer.MAX_VALUE) : b[m2];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2); //we find max element
            }
            else if(l2>r1){
                l=m1+1;
            }
            else{
                h=m1-1;
            }
        }
        
        return 0;
    }
    
    public static void main(String aggs[]){
       int a[]={2, 3, 6, 7, 9};
       int b[] = {1, 4, 8, 10,12};
       int k = 5;
     
    //    brute force approach
    //    int res=merge(a,b,k);

    // optimized approach
    int res=findKthElement(a,b,k);
    System.out.println(res);
       
    }
}
