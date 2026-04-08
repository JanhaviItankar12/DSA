import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class DistinctIslandsWithRotationAndReflection {


    public static void bfs(int i,int j,int mat[][],boolean visited[][],ArrayList<int[]> cells){

       Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;

        int row=mat.length;
        int col=mat[0].length;

        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){

            int curr[]=q.remove();

            int r=curr[0];
            int c=curr[1];

            cells.add(new int[]{r,c});  //save positions to cell

            for(int dir[]:dirs){
               
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nc>=0 && nr<row && nc<col && mat[nr][nc]==1 && !visited[nr][nc] ){
                     q.add(new int[]{nr,nc});
                     visited[nr][nc]=true;
                }
            }
        }

    }

    public static String normalize(ArrayList<int[]> cells){
          
        ArrayList<ArrayList<int[]>> transformed=new ArrayList<>();

        //possible transorformation would be 8 (4 rotation +4 reflection)
        for(int i=0;i<8;i++){
            transformed.add(new ArrayList<>());
        }

        

        for(int p[]:cells){

            int x=p[0];
            int y=p[1];

            //transformed
            transformed.get(0).add(new int[]{x,y});
            transformed.get(1).add(new int[]{-x,y});
            transformed.get(2).add(new int[]{x,-y});
            transformed.get(3).add(new int[]{-x,-y});
            transformed.get(4).add(new int[]{y,x});
            transformed.get(5).add(new int[]{-y,x});
            transformed.get(6).add(new int[]{y,-x});
            transformed.get(7).add(new int[]{-y,-x});

           
        }

        ArrayList<String> finalShape=new ArrayList<>();

        for(ArrayList<int[]>shape:transformed){

            StringBuilder str=new StringBuilder();

            //sorting 
            Collections.sort(shape,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

            int base[]=shape.get(0);

            //replative shape
            int baseX=base[0];
            int baseY=base[1];

            for(int p[]:shape){
                //now add relative shape
                str.append((p[0]-baseX)+","+(p[1]-baseY)+"|");
            }
            
            //now add each type of transformation into final shape
            finalShape.add(str.toString());


        }

        //sort to get final one shape 
        Collections.sort(finalShape);

        //send final one shape among all transformation
        return finalShape.get(0);

        

    }
    public static void main(String[] args) {
        int mat[][]={
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };

        int row=mat.length;
        int col=mat[0].length;
        boolean visited[][]=new boolean[row][col];
        
        Set<String> set=new HashSet<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1 && !visited[i][j]){

                    // step1:find all islands  and store tthier poistions in cells
                    ArrayList<int[]> cells=new ArrayList<>();
                    bfs(i,j,mat,visited,cells);

                    //step2:now all postitions we have to transformed
                    set.add(normalize(cells));  
                }
            }
        }

        System.out.println(set.size());


    }
}
