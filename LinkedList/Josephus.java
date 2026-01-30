class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;

    }
}

public class Josephus {
  public static void main(String[] args) {

    int n=5;
    int k=2;
    Node head=new Node(1);

    Node curr=head;
    for(int i=2;i<=n;i++){
        Node newNode=new Node(i);
        curr.next=newNode;
        curr=newNode;
    }
    
    curr.next=head;
    Node prev=curr;
    curr=head;


    while(curr.next!=curr){

        for(int i=1;i<k;i++){
            prev=curr;
            curr=curr.next;
        }

        prev.next=curr.next;
        curr=curr.next;
    }

    System.out.println(curr.data);
      
  }
    
}
