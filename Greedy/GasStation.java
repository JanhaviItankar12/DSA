
public class GasStation {

    public static void Optimal(int gas[],int cost[],int n){
        
        int totalGas=0,requireGas=0,remainingGas=0;
        int start=0;

        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            requireGas+=cost[i];
            remainingGas+=gas[i]-cost[i];

            if(remainingGas<0){
              start=i+1;
              remainingGas=0;
            }

        }

        if(totalGas<requireGas){
            System.out.println(-1);
            return;
        }
        
        System.out.println(start);
        return;
    }
    
    public static void main() {
        // code here

         int gas[]={4,5,7,6};
         int cost[]={6,6,3,5};
         int n=gas.length;
        
         Optimal(gas,cost,n);
        
       
        
        
        
        
    }
}

