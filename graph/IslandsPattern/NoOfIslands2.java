import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class NoOfIslands2 {

    public static int find(int index,int parent[]){

        if(parent[index]!=index){
            parent[index]=find(parent[index],parent);
        }
        return parent[index];

    }

    public static void Union(int rank[],int i,int n,int parent[]){
          
        int x=find(i,parent);
        int y=find(n,parent);

        if(x==y){
            return;
        }

        if(rank[x]>rank[y]){
            parent[y]=x;
        }
        else if(rank[y]>rank[x]){
            parent[x]=y;
        }
        else{
            parent[y]=x;
            rank[x]++;
        }

         
    }

    public static ArrayList<Integer> optimizedApproach(List<List<Integer>> positionList,int r,int c){
        ArrayList<Integer> res=new ArrayList<>();

        int parent[]=new int[r*c];
        int rank[]=new int[r*c];
        int count=0;
        Arrays.fill(parent,-1);

        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};

        for(List<Integer> pos:positionList){
              int a=pos.get(0);
              int b=pos.get(1);


              int index=a*c+b;  //index

              if(parent[index]!=-1){
                res.add(count);
                continue;
              }

              parent[index]=index;
              count++;

              for(int dir[]:dirs){

                 int m=a+dir[0];
                 int n=b+dir[1];

                 if(m>=0 && n>=0 && m<r && n<c){
                    int newIndex=m*c+n;

                    if(parent[newIndex]!=-1){
                       if(find(index,parent)!=find(newIndex,parent)){
                          Union(rank,index,newIndex,parent);
                          count--;
                       }
                    }
                 }
              }

              res.add(count);

              
        }

        return res;
    }

    public static void bfs(int i,int j,boolean visited[][],int grid[][]){

        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{i,j});
        visited[i][j]=true;

        int row=grid.length;
        int col=grid[0].length;

        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){

            int curr[]=q.remove();

            for(int dir[]:dirs){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];

                if(r>=0 && c>=0 && r<row && c<col && grid[r][c]==1 && !visited[r][c]){
                    visited[r][c]=true;
                    q.add(new int[]{r,c});
                }
            }

        }
    }

    
    public  static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        //take input for size of matrix ;
        System.out.print("Enter size of row:");
        int rows = sc.nextInt();
        System.out.print("Enter size of col:");
        int cols = sc.nextInt();

        List<List<Integer>> positionList=new ArrayList<>();
        
        for(int i=0;i<rows;i++){
            boolean isSkip=false;
            for(int j=0;j<cols;j++){
              System.out.println("Enter position where you want to create island or enter -1 to skip:");
              int a=sc.nextInt();
              if(a==-1){
                isSkip=true;
                break;
              }
              int b=sc.nextInt();

              //add it to position list
              positionList.add(Arrays.asList(a,b));
            }

            if(isSkip){
                break;
            }
        }


        //option1:brute force approach
        int grid[][]=new int [rows][cols];
        ArrayList<Integer> res=new ArrayList<>();

        for(List<Integer> pos:positionList){
            int a=pos.get(0);
            int b=pos.get(1);
            
            grid[a][b]=1;  //mark land
            
            //find no of islands
            boolean visited[][]=new boolean[rows][cols];
            int count=0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j]==1 && !visited[i][j]){
                        //call bfs
                        bfs(i,j,visited,grid);
                        count++;
                    }
                }

            }
            res.add(count);
        }
        System.out.println(res);

        //option2:optimized approach
        ArrayList<Integer> ans=new ArrayList<>();
        ans=optimizedApproach(positionList,rows,cols);
        System.out.println(ans);




    }
}
