
import java.util.ArrayList;

public class primeFactor {
    public static void main(String[] args) {
        int n=31;
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        // O(root(n))
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
              list.add(i);

              if(i!=n/i){
                list.add(n/i);
              }
            }
          
        }

        if(list.size()==0){
            list2.add(n);
        }
        
        System.out.println(list);
        int arr[]=new int[list.size()];
        
        // O(n)
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        int m=arr.length;

       
        
        // O(n(rootn))
        for(int i=0;i<m;i++){
            boolean isPrime=true;
            for(int j=2;j*j<=arr[i];j++){
                if(arr[i]%j==0){
                   isPrime=false;
                }
            }
            if(isPrime){
              list2.add(arr[i]);
            }
        }

        System.out.println(list2);



    }
}
