

public class FindMinSum{
    public static void main(String args[]){
       int[] arr = {6, 8, 4, 5, 2, 3};

        int n=arr.length;

        // step1:count frequency of element
        int count[]=new int[10];

        for(int i=0;i<n;i++){
          int digit=arr[i];
          count[digit]++;
        }

        // Step2:find two num for minimum sum
        int num1=0;
        int num2=0;
        boolean moveFirst=true;

        for(int i=0;i<count.length;i++){
            while(count[i]>0){
              if(moveFirst){
                num1=num1*10+i;
              }
              else{
                num2=num2*10+i;
              }
              moveFirst=!moveFirst;
              count[i]--;
            }
        }

        //Step3: find min sum
        int sum=num1+num2;
        String res=String.valueOf(sum);
        System.out.println(res.replaceFirst("^0+", ""));
        
        
    }
}