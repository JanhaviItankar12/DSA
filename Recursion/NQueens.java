import java.util.ArrayList;

public class NQueens {

    public static boolean isSafe(int[][]board,int n,int row,int col){
        
        //check for row 
        for(int i=0;i<n;i++){
            if(board[row][i]==1){
                return false;
            }
        }
        
        //check for col
        for(int i=0;i<n;i++){
            if(board[i][col]==1){
                return false;
            }
        }


        //check diagonally  -left side
        for(int i=row,j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //right side
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
           if(board[i][j]==1){
            return false;
           }
        }


        
        return true;
    }

    public static void nQueens(int board[][],int n,int row,ArrayList<ArrayList<Integer>> ans){

        if(row==n){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                   if(board[i][j]==1){
                      temp.add(j+1);
                   }
                }
                
            }
            ans.add(temp);
            return;
        }

        //try to put queen on col of chess board on each row
        for(int i=0;i<n;i++){
            if(isSafe(board,n,row,i)){
                board[row][i]=1;
                nQueens(board, n, row+1,ans);
                board[row][i]=0;
            }
        }
    }
    public static void main(String[] args){

        int n=4;
        int board[][]=new int[4][4];
        int row=0;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        

        nQueens(board,n,row,ans);

        System.out.println(ans);
    }
}
