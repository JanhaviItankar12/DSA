import java.util.ArrayList;

public class heapDeletion {
    static ArrayList<Integer> minHeap=new ArrayList<>();
    static ArrayList<Integer> maxHeap=new ArrayList<>();
    

    public static void deleteMinHeap(int size){

        if(size==0){
            return;
        }

         minHeap.set(0,minHeap.get(size-1));
         
         minHeap.remove(size-1);
         
         minheapify(minHeap.size(),0);
    }

    public static void minheapify(int size,int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<size && minHeap.get(left)<minHeap.get(smallest)){
            smallest=left;
        }

        if(right<size && minHeap.get(right)<minHeap.get(smallest)){
            smallest=right;
        }

        if(smallest!=i){
            int temp=minHeap.get(i);
            minHeap.set(i,minHeap.get(smallest));
            minHeap.set(smallest,temp);
            minheapify(size,smallest);
        }
    }

    public static void deleteMaxHeap(int size){
       
        if(size==0){
            return;
        }

        maxHeap.set(0,maxHeap.get(size-1));
        maxHeap.remove(size-1);
        maxHeapify(maxHeap.size(),0);
    }

    public static void maxHeapify(int size,int i){

        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<size && maxHeap.get(left)>maxHeap.get(largest)){
            largest=left;
        }

        if(right<size && maxHeap.get(right)>maxHeap.get(largest)){
            largest=right;
        }

        if(largest!=i){
            int temp=maxHeap.get(i);
            maxHeap.set(i,maxHeap.get(largest));
            maxHeap.set(largest,temp);
           
            maxHeapify(size, largest);
        }
    }


    public static void main(String[] args) {
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(50);

        deleteMinHeap(minHeap.size());
        System.out.println(minHeap);

        maxHeap.add(50);
        maxHeap.add(40);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(10);

        deleteMaxHeap(maxHeap.size());
        System.out.println(maxHeap);


    }
}
