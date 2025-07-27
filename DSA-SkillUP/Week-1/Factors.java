
import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        int n=10;

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                list.add(i);

                if(i!=n/i){
                    list.add(n/i);
                }
            }
        }
        System.out.println(list);
    }
}
