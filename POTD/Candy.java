public class Candy {
    public static void main(String[] args) {
        
        int student[]={5, 4 ,9, 0, 0, 1, 9, 5, 2, 6};
        int n=student.length;

        //give all children to one candy-as they should have atleast one candy
        
        int candy[]=new int[n];
        for(int i=0;i<n;i++){
            candy[i]++;
           
        }
        
       
        for(int i=1;i<n;i++){
          if(student[i]>student[i-1]){
            candy[i]=candy[i-1]+1;
          }
        }

        for(int i=n-2;i>=0;i--){
            if(student[i]>student[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        
        int totalCandies=0;
        for(int i=0;i<n;i++){
           totalCandies+=candy[i];
        }

        System.out.println(totalCandies);

       



    }
}
