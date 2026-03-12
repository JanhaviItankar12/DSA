import java.util.ArrayList;

public class heapInsertion {

    static ArrayList<Integer> minheap=new ArrayList<>();
    static ArrayList<Integer> maxHeap=new ArrayList<>();

    public static void insertMin(int value){
        minheap.add(value);
        int i=minheap.size()-1;

        while(i>0){
            int parent=(i-1)/2;

            if(minheap.get(parent)>minheap.get(i)){
                int temp=minheap.get(parent);
                minheap.set(parent,minheap.get(i));
                minheap.set(i,temp);
                i=parent;
            }
            else{
                break;
            }
        }
    }

    public static void insertMax(int value){
        maxHeap.add(value);
        int i=maxHeap.size()-1;

        while(i>0){
            int parent=(i-1)/2;

            if(maxHeap.get(parent)<maxHeap.get(i)){
                int temp=maxHeap.get(parent);
                maxHeap.set(parent,maxHeap.get(i));
                maxHeap.set(i,temp);
                i=parent;
            }
            else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        minheap.add(10);
        minheap.add(20);
        minheap.add(30);
        minheap.add(40);
        minheap.add(50);
        insertMin(5);

        maxHeap.add(90);
        maxHeap.add(80);
        maxHeap.add(70);
        maxHeap.add(40);
        maxHeap.add(50);
        insertMax(205);

        System.out.println(maxHeap);


    }
}
