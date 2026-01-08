

public class SmartStreetLight {

    
    public static void main(String[] args) {
        String s="01101";

        int n=s.length();
        int cost0=0;
        int cost1=0;

        for(int i=0;i<n;i++){

            char exp0=(i%2==0) ? '0' : '1';
            char exp1=(i%2==0) ? '1' : '0';

            if(exp0!=s.charAt(i)){
                cost0++;
            }
            if(exp1!=s.charAt(i)){
                cost1++;
            }
        }

        System.out.println(Math.min(cost0,cost1));
        
    }
}
