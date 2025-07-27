

import java.util.ArrayList;
import java.util.Arrays;

public class AllPrime {
    public static void main(String[] args) {
        int n=3;
        ArrayList<Integer> list=new ArrayList<>();

        // bruteForce- Approach -TC(n*root(n))
        // for(int i=2;i<=n;i++){
        //     boolean isFactor=false;
        //     for(int j=2;j<=Math.sqrt(i);j++){
        //         if(i%j==0){
        //           isFactor=true;
        //         }
        //     }
        //     if(!isFactor){
        //         list.add(i);
        //     }
        // }
         
        // TC-O(n.log log n)
        boolean isPrime[]=new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
               for(int j=i*i;j<=n;j+=i){
                 isPrime[j]=false;
               }
            }
        }

        for(int i=0;i<=n;i++){
            if(isPrime[i]){
                list.add(i);
            }
        }

        System.out.println(list);
    }
}
