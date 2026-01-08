class Queue{
     int n=5;
     int arr[]=new int[n];
     int front=0,rear=-1;

    void enQueue(int a){

        if(rear==n-1){
            System.out.println("Queue OverFlow");
            return;
        }
        arr[++rear]=a;
    }

    void deQueue(){

        if(front>rear){
            System.out.println("Queue UnderFlow");
            return;
        }
        System.out.println(arr[front]);
        front++;
    }

    void print(){
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}

public class QueueUsingArray {
    public static  void main(String[] args) {
        Queue q=new Queue();

        q.enQueue(3);
        q.enQueue(30);
        q.enQueue(13);
        q.enQueue(33);
        q.enQueue(53);

        q.deQueue();

        q.print();

        
    }
}
