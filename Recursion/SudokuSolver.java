public class SudokuSolver {

    public static void print(int mat[][],int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean isSafe(int mat[][],int row,int col,int num,int n){

       

        //check in rows and col
        for(int i=0;i<n;i++){
            if(mat[row][i]==num || mat[i][col]==num){
                return false;
            }
        }

         // correct 3x3 grid check
        int gridRow = (row / 3) * 3;
        int gridCol = (col / 3) * 3;

        for(int i=gridRow;i<gridRow+3;i++){
            for(int j=gridCol;j<gridCol+3;j++){
                if(mat[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int mat[][],int n) {
        

        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==0){
                    for(int num=1;num<=9;num++){
                        if(isSafe(mat,row,col,num,n)){
                            mat[row][col]=num;
                            if(solveSudoku(mat, n)){
                               return true;
                            }
                            mat[row][col]=0;
                        }
                    }
                    return false;
                }
            }
        }

        return true;


    }

    public static void main(String args[]){

        int mat[][]={
            {3,0,6,5,7,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,8,6,3,0,0}
        };

       
        int n=9;

        if(solveSudoku(mat,n)){
            print(mat,n);
        }
        else{
            System.out.println("Not possible to solve");
        }


    }
    
}
