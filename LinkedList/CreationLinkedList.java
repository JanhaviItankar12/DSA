package LinkedList;

class Node{
    int data;
    Node next;

    // constructor
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
   Node head;

   //insert at begining
   public void insertAthead(int data){
     Node newNode=new Node(data);

     newNode.next=head;
     head=newNode;
   }
   
   //insert at end
   public void inserAtend(int data){
     Node newNode=new Node(data);

     //list is empty
     if(head==null){
        head=newNode;
        return ;
     }

     Node curr=head;
     while(curr.next!=null){
        curr=curr.next;
     }

     curr.next=newNode;
   }

   //at the specific position
   public void insertAtpos(int data,int index){
   
    if(index==0){
        insertAthead(data);
        return;
    }

    Node newNode=new Node(data);
    Node curr=head;

    for(int i=0;i<index-1;i++){
        curr=curr.next;
    }

    newNode.next=curr.next;
    curr.next=newNode;

    }

    //deletion

    //at head
    public void deleteAthead(){

        if(head!=null){
            head=head.next;
        }
    }

    //delete at end
    public void deleteAtend(){
       
        if(head==null || head.next==null){
            head=head.next;
            return;
        }

        Node curr=head;

        while(curr.next.next!=null){
            curr=curr.next;
        }

        curr.next=null;
    }

    public void deleteAtpos(int index){
        
        if(index==0){
            deleteAthead();
            return;
        }


        Node curr=head;
        for(int i=0;i<index-1;i++){
           curr=curr.next;
        }

        curr.next=curr.next.next;

    }

    public void printList(){
        Node curr=head;

        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }

        System.out.print("null");
    }


}
public class CreationLinkedList {
    public static void main(String[] args){
        LinkedList ll1=new LinkedList();

        ll1.insertAthead(10);
        ll1.inserAtend(90);
        ll1.inserAtend(80);
        ll1.insertAtpos(20, 1);

        ll1.printList();

        ll1.deleteAthead();
        ll1.deleteAtend();
        ll1.deleteAtpos(0);

        ll1.printList();


    }

    
}
