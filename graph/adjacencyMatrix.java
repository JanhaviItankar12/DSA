class Graph{
    int matrix[][];
    int v;

    Graph(int v){
        this.v=v;
        matrix=new int[v][v];
    }

    void addEdge(int u,int v){
        matrix[u][v]=1;
        matrix[v][u]=1;
    }

    void printGraph(){
        int n=matrix.length;

        for(int i=0;i<n;i++){
          
            for(int j=0;j<n;j++){
               System.out.print(matrix[i][j]+" ");
                
            }
            System.out.println();
        }
    }
}

public class adjacencyMatrix {
    public static void main(String[] args) {
        Graph g=new Graph(3);

        g.addEdge(2,0);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        
        g.printGraph();
    }
}
