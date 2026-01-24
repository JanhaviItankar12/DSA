public class CelebrityProblem {
    public static void main(String[] args) {

        int arr[][]={{1,1,0},
            {0,1,0},
            {0,1,1}
    };

     int row=arr.length;
     int col=arr[0].length;

     
    //  //brute force
    //  for(int i=0;i<row;i++){
    //     boolean isFound=true;
    //     for(int j=0;j<col;j++){
    //        if(arr[i][j]==1 && i!=j){
    //          isFound=false;
    //          break;
    //        }
    //     }

    //     if(isFound){
    //         System.out.println("Celebrity Exist");
    //         return;
    //     }
    //  }


     //optimal approach

     //find candidate
     int candidate=0;
     for(int i=1;i<col;i++){
         if(arr[candidate][i]==1){
            candidate=1;
         }
     }

     //verify celebrity or not
     for(int i=0;i<row;i++){
        if(i!=candidate){
            if(arr[candidate][i]==1 || arr[i][candidate]==0){
                System.out.println("Celebrity doesn't exist!");
                break;
            }
        }
     }

     System.out.println("Celebrity Exist!!");

    
     

        
    }
}
