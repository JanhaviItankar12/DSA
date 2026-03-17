import java.util.*;


class Graph{
    int v;
    ArrayList<ArrayList<Integer>>  adj;

    Graph(int v){
        this.v=v;
        adj=new ArrayList<>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void printGraph(){
        for(int i=0;i<v;i++){
            System.out.print(i+"->");
            for(int node:adj.get(i)){
                System.out.print(node+" ");
            }
            System.out.println();
        }
    }


}
public class adjacencyList {
    public static void main(String[] args) {
        Graph g=new Graph(3);
        
        g.addEdge(0, 1);
        g.addEdge(0,2);

        g.printGraph();

    }
}
