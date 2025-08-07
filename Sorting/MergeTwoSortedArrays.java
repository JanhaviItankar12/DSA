public class MergeTwoSortedArrays {

     static void  mergeArrays(int a[], int b[]) {
        // code here
        int n=a.length;
        int m=b.length;
        int arr[]=new int [n+m];
        int k=0;
        int i=0;
        int j=0;
        
        while(i<n && j<m){
            if(a[i]<=b[j]){
                arr[k]=a[i];
                k++;
                i++;
            }
            else{
                arr[k]=b[j];
                k++;
                j++;
            }
        }
        
        while(i<n){
            arr[k]=b[i];
            k++;
            i++;
        }
        
        while(j<m){
            arr[k]=b[j];
            k++;
            j++;
        }

        
        
        k=0;
        for(int s=0;s<n;s++){
            a[s]=arr[s];
            k++;
        }
        
        
        int r=0;
        for(int s=k;s<arr.length;s++){
            b[r]=arr[s];
            r++;
        }

        for(int v=0;v<n;v++){
            System.out.print(a[v]+" ");
        }

        for(int v=0;v<m;v++){
            System.out.println(b[v]+" ");
        }


    }
    public static void main(String[] args) {
        int a[]={1,3,5,7};
        int b[]={0,2,6,8,9};

        mergeArrays(a,b);

        
    }
}
