class BinaryCounter{
    int[] counter;
    int n;

    public BinaryCounter(int size){
        n=size;
        counter=new int[n];   //intialized to 0
    }

    public int increment(){
        int flips=0;

        for(int i=0;i<n;i++){
            if(counter[i]==0){
               counter[i] =1;
               flips++;   //one flip
               break;
            }
            else{
                counter[i]=0;
                flips++;
            }
        }

        return flips;
    }

    public void display() {
        for(int i=n-1;i>=0;i--){
            System.out.println(counter[i]);
        }
        System.out.println();
    }
}

public class AmortalisedAnalysis {
    public static void main(String[] args) {
        BinaryCounter bc=new BinaryCounter(4);

        int operations=10;
        int totalFlips=0;

        for(int i=1;i<=operations;i++){
            int flips=bc.increment();
            totalFlips+=flips;

            System.out.print("Step:"+i+":");
            bc.display();
            System.out.println("Flips in this step:"+flips);
            System.out.println();
        }

        System.out.println("Total flips:"+totalFlips);
        System.out.println("Amortized cost:"+(double) totalFlips/operations);
    }
}
